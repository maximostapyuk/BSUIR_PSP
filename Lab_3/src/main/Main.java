package main;

import shoesTypes.*;

public class Main {
    public static void main(String[] args) {
        Sandals sandals=new Sandals(39,"Беларусь","Черный",3,true);
        Boots boots=new Boots(42,"Польша","Синий",2,false,1);
        Sneakers sneakers=new Sneakers(44,"Афганистан","Бело-черный",
                1, "Полиуретан");

        sandals.printInfoSandals();
        boots.printInfoBoots();
        sneakers.printInfoSneakers();
    }
}
