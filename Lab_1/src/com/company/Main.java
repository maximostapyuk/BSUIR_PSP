package com.company;

public class Main {
    public static void main(String[] args) {
        Tribe tribe = new Tribe(2300,"Кривичи", true);
        WriterInfo writerInfo = WriterInfo.getInstance(tribe);
        Tribe tribe1 = new Tribe(1000,"Дриговичи", false);
        writerInfo.printInfo();

        WriterInfo writerInfo1 = WriterInfo.getInstance(tribe1);
        writerInfo1.printInfo();
    }
}
