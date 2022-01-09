package Tribe;

public class WriterInfo {
    private static WriterInfo instance;
    public Tribe tribe;

    public WriterInfo(Tribe tribe){
        this.tribe = tribe;
    }

    public static WriterInfo getInstance(Tribe tribe){
        if(instance==null){
            instance=new WriterInfo(tribe);
        }
        return instance;
    }

    public void printInfo(){
        System.out.println("----------------------------------------------");
        this.tribe.printNumber(this.tribe);
        this.tribe.printName(this.tribe);
        this.tribe.printIntroductionToFire(this.tribe);
        System.out.println("----------------------------------------------");
    }
}
