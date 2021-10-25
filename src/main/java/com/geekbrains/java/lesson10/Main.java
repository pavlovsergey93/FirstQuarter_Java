package com.geekbrains.java.lesson10;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String word[] = new String[] {"get", "apple", "run", "lesson","commit", "rebase", "branch","commit", "git", "school", "find", "apple", "master", "commit"};
        findWord(word);
        System.out.println();

        LinkedList<Phone> phoneBook= new LinkedList<>();
        Phone phone0 = new Phone("Вася", "+375(29)667-41-91");
        Phone phone1 = new Phone("Коля", "+375(25)997-65-65");
        Phone phone2 = new Phone("Вася", "+375(44)695-57-60");
        Phone phone3 = new Phone("Тима", "+375(29)957-35-65");
        Phone phone4 = new Phone("Петя", "+375(33)134-62-71");
        Phone phone5 = new Phone("Коля", "375(44)847-96-34");
        phoneBook.add(phone0);
        phoneBook.add(phone1);
        phoneBook.add(phone2);
        phoneBook.add(phone3);
        phoneBook.add(phone4);
        phoneBook.add(phone5);
        String findSurname = "Вася";
        if (!findContect(findSurname, phoneBook)) {
            System.out.println("Контакт по запросу <<" + findSurname + ">> не найден.");
            return;
        }
    }

    public static void findWord(String words[]){
        HashMap<String, Integer> wordList = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            int k = 0;
            for (int j = 0; j < words.length; j++) {
                if(words[i] == words[j]) k++;
            }
            wordList.put(words[i], k);
        }
        for (Map.Entry<String, Integer> o: wordList.entrySet()){
            System.out.println(o.getKey() + " /повторяется " + o.getValue() + " раз(а)");
        }
    }
    public static boolean findContect(String surname, LinkedList<Phone> phoneBook){
        int k = 0;
        for (int i = 0; i < phoneBook.size(); i++){
            if(phoneBook.get(i).getSurname().equals(surname)){
                System.out.println(phoneBook.get(i).getSurname() + ": " + phoneBook.get(i).getNumberPhone());
                k++;
            }
        }
        if(k != 0) return true;
        return false;
    }
}
