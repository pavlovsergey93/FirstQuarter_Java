package com.geekbrains.java.lesson5;

public class Main {
    public static void main(String[] args) {
        Worker worker = new Worker("Pavlov", "Sergey", "Vital`evich", "master",
                "pavlovsv93@gmail.com", 7143689, 1500, 28);
        worker.printInfoWorker();
        Worker arrayWorker[] = new Worker[5];
        arrayWorker[0] = new Worker("Belenya", "Pavel", "Vladimirovich", "st.mehanik",
                "belenPVlad@gmail.com", 7559243, 1350, 40);
        arrayWorker[1] = new Worker("Maremuha", "Vladimir", "Leonidovich", "mehanik",
                "pavlovsv93@gmail.com", 2679583, 1200, 62);
        arrayWorker[2] = new Worker("Bachilo", "Andrey", "Igorevich", "st.master",
                "pavlovsv93@gmail.com", 8596731, 1700, 42);
        arrayWorker[3] = new Worker("Polyak", "Aleksandor", "Sergeevich", "mehanik",
                "pavlovsv93@gmail.com", 7448239, 1230, 30);
        arrayWorker[4] = new Worker("Lobazenko", "Artem", "Aleksandrovich", "slesar",
                "pavlovsv93@gmail.com", 1975688, 1100, 25);
        printWorker(arrayWorker);

        public void printWorker(){
            for (int i = 0; i < 5; i++){
                if (  >= 40){
                    arrayWorker[i].printInfoWorker();
                }
            }
        }



    }
}
