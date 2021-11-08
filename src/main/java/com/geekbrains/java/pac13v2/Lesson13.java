package com.geekbrains.java.pac13v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Lesson13 {
    public static final int CARS_COUNT = 4;
    public static final CountDownLatch waitCars = new CountDownLatch(CARS_COUNT);
    public static final CountDownLatch waitFinishCars = new CountDownLatch(CARS_COUNT);
    public static final CyclicBarrier prepareCars = new CyclicBarrier(CARS_COUNT);
    public static final Semaphore semaphoreTunnel = new Semaphore(CARS_COUNT/2);

    public volatile static boolean isWinner = false;
    public volatile static boolean choosingWinnerFlag = false;
    public static final CountDownLatch choosingWinnerCDL = new CountDownLatch(1);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

        Car[] cars = new Car[CARS_COUNT];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }
        waitCars.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        waitFinishCars.await();
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }

    public static void printWinner(String name) {
        System.out.println(name + " WIN");
        Lesson13.isWinner = true;
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
            Lesson13.prepareCars.await();
            System.out.println(this.name + " готов");
            Lesson13.waitCars.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        if (!Lesson13.isWinner) {
            Lesson13.choosingWinnerFlag = true;
            Lesson13.printWinner(this.name);
            Lesson13.choosingWinnerCDL.countDown();
            Lesson13.choosingWinnerFlag = false;
        }

        Lesson13.waitFinishCars.countDown();
    }
}
 class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }
}
 class Road extends Stage {
    public Road(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            while (Lesson13.choosingWinnerFlag) {
                Lesson13.choosingWinnerCDL.await();
            }
            System.out.println(c.getName() + " начал этап: " + description);

            while (Lesson13.choosingWinnerFlag) {
                Lesson13.choosingWinnerCDL.await();
            }
            Thread.sleep(length / c.getSpeed() * 1000);

            while (Lesson13.choosingWinnerFlag) {
                Lesson13.choosingWinnerCDL.await();
            }
            System.out.println(c.getName() + " закончил этап: " + description);

            while (Lesson13.choosingWinnerFlag) {
                Lesson13.choosingWinnerCDL.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
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
 class Tunnel extends Stage {
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {

                while (Lesson13.choosingWinnerFlag) {
                    Lesson13.choosingWinnerCDL.await();
                }
                System.out.println(c.getName() + " готовится к этапу(ждет): " +
                        description);

                while (Lesson13.choosingWinnerFlag) {
                    Lesson13.choosingWinnerCDL.await();
                }
                Lesson13.semaphoreTunnel.acquire();

                while (Lesson13.choosingWinnerFlag) {
                    Lesson13.choosingWinnerCDL.await();
                }
                System.out.println(c.getName() + " начал этап: " + description);

                while (Lesson13.choosingWinnerFlag) {
                    Lesson13.choosingWinnerCDL.await();
                }
                Thread.sleep(length / c.getSpeed() * 1000);

                while (Lesson13.choosingWinnerFlag) {
                    Lesson13.choosingWinnerCDL.await();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {

                while (Lesson13.choosingWinnerFlag) {
                    Lesson13.choosingWinnerCDL.await();
                }
                System.out.println(c.getName() + " закончил этап: " +
                        description);

                while (Lesson13.choosingWinnerFlag) {
                    Lesson13.choosingWinnerCDL.await();
                }
                Lesson13.semaphoreTunnel.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
