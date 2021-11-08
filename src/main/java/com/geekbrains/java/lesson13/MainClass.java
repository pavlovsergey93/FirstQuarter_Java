package com.geekbrains.java.lesson13;

import com.geekbrains.java.lesson5.Main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainClass {
    public static final int CARS_COUNT = 4;
    public static CountDownLatch cdlReady = new CountDownLatch(CARS_COUNT);
    public static CountDownLatch cdlFinish = new CountDownLatch(CARS_COUNT);
    public static CyclicBarrier cd = new CyclicBarrier(CARS_COUNT);
    public static Semaphore smp = new Semaphore(CARS_COUNT/2);
    public static Lock lock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 100));
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        cdlReady.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        cdlFinish.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
class Car implements Runnable {
    private static int CARS_COUNT;
    private Race race;
    private int speed;
    private String name;
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {

        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            MainClass.cd.await();
            MainClass.cdlReady.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            MainClass.cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try {
            MainClass.lock.lock();
            System.out.println(this.getName() + " >>>>> ФИНИШИРОВАЛ!!!!");
            MainClass.cdlFinish.countDown();
            if (MainClass.cdlFinish.getCount() == (CARS_COUNT - 1)) {
                System.out.println(">>>>>>>>>>>>>>>>> " + this.getName() + " WIN!!!");
            }
        }finally {
            MainClass.lock.unlock();
        }
    }
}
abstract class Stage {
    protected int length;
    protected String description;
    public String getDescription() {
        return description;
    }
    public abstract void go(Car c);
}
class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                MainClass.lock.lock();
                System.out.println(c.getName() + " начал этап: " + description);
            } finally {
                MainClass.lock.unlock();
            }
            Thread.sleep(length / c.getSpeed() * 1000);
            try {
                MainClass.lock.lock();
                System.out.println(c.getName() + " закончил этап: " + description);
            } finally {
                MainClass.lock.unlock();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                try {
                    MainClass.lock.lock();
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                } finally {
                    MainClass.lock.unlock();
                }
                MainClass.smp.acquire();
                try {
                    MainClass.lock.lock();
                    System.out.println(c.getName() + " начал этап: " + description);
                } finally {
                    MainClass.lock.unlock();
                }
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                try {
                    MainClass.lock.lock();
                    System.out.println(c.getName() + " закончил этап: " + description);
                } finally {
                    MainClass.lock.unlock();
                }
                MainClass.smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
