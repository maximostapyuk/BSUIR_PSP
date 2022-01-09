package com.company;

public class Tribe {
    private int number;
    private String name;
    private boolean introductionToFire;

    public Tribe(int number, String name, boolean introductionToFire) {
        this.number = number;
        this.name = name;
        this.introductionToFire = introductionToFire;
    }
    public Tribe(int number, String name) {
        this.number = number;
        this.name = name;
        this.introductionToFire =false;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public boolean isIntroductionToFire() {
        return introductionToFire;
    }

    public void setNumber(int number){
        this.number=number;
    }

    public void setName(String surname){
        this.name =surname;
    }

    public void setIntroductionToFire(boolean introductionToFire){
        this.introductionToFire = introductionToFire;
    }

    public void printNumber(Tribe tribe){
        System.out.println("Численность племени: "+ tribe.number);
    }

    public void printName(Tribe tribe){
        System.out.println("Название: "+ tribe.name);
    }

    public void printIntroductionToFire(Tribe tribe){
        if (tribe.introductionToFire == true)
            System.out.println("С огнем знакомо.");
        else
            System.out.println("С огнем не знакомо.");
    }

}
