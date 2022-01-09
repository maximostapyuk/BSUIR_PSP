package main;

import shoeseTypes.*;

public class Main {
    public static void main(String[] args) {
        FlipFlop sandals=new FlipFlop(39,"Беларусь","Черный",3, true,8);
        Boots boots=new Boots(42,"Польша","Синий",2,false,1);
        Sneakers sneakers=new Sneakers(44,"Афганистан","Бело-черный",1, "Полиуретан");
        Wedges wedges=new Wedges(36,"Польша","Желтый",3,"Поливинилхлорид",4);

        sandals.printInfo();
        boots.printInfo();
        sneakers.printInfo();
        wedges.printInfo();

    }
}
