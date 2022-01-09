package Main;

import Tribe.*;

public class Main {
    public static void main(String[] args) {
        Tribe.tribesNumber=3;
        Tribe [] tribes=new Tribe[Tribe.tribesNumber];
        tribes[0] =new Tribe(3600,"Кривичи",true);
        tribes[1] =new Tribe(800,"Дриговичи",true);
        tribes[2] =new Tribe(2400,"Радимич");

       for (int i=0;i<Tribe.tribesNumber;i++) {
           WriterInfo writerInfo = new WriterInfo(tribes[i]);
           writerInfo.printInfo();
       }

       System.out.println("Общая численность: " + Tribe.countTotalNumber(tribes));
       System.out.println("Количество племен, знакомых с огнем: " + Tribe.countNumberIntroductionToFire(tribes));
    }
}
