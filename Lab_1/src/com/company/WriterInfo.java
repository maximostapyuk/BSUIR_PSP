package com.company;

public class WriterInfo {
    private static WriterInfo instance;
    public Tribe tribe;

    private WriterInfo(Tribe tribe){
        this.tribe = tribe;
    }

    public static WriterInfo getInstance(Tribe tribe){
        if(instance==null){
            instance=new WriterInfo(tribe);
        }
        return instance;
    }

    public void printInfo(){
        this.tribe.printNumber(this.tribe);
        this.tribe.printName(this.tribe);
        this.tribe.printIntroductionToFire(this.tribe);
    }
}
