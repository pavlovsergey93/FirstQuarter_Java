package com.geekbrains.java.lesson10;

public class Phone {
    private String surname;
    private String numberPhone;
    Phone(String surname, String number){
        setSurname(surname);
        setNumberPhone(number);

    }
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }


}
