package shoeseTypes;

import templates.Sandals;

public class Wedges extends Sandals {
    private int size;
    private String manufacturer;
    private String color;
    private int brandID;
    private String soleType;
    private int heelSize;

    public Wedges() {
        soleType=new String();
        size=0;
        manufacturer=new String();
        color=new String();
        brandID=1;
        heelSize=0;
    }

    public Wedges(int size, String manufacturer, String color,
                    int brandID, String soleType, int heelSize) {
        this.size = size;
        this.manufacturer = manufacturer;
        this.color = color;
        this.brandID = brandID;
        this.soleType = soleType;
        this.heelSize = heelSize;
    }


    @Override
    public void printInfo() {
        System.out.println("*************************************");
        System.out.println("Размер: " + size+" Производитель: "+ manufacturer+" Цвет: "+color);
        this.brand();
        System.out.println("Размер каблука: "+heelSize+" см");
        System.out.println("Тип подошвы:"+soleType);
        System.out.println("*************************************");

    }

    @Override
    public void brand() {
        switch (this.brandID){
            case 1:
                System.out.println("Бренд обуви: Марко");break;
            case 2:
                System.out.println("Бренд обуви: Белвест");break;
            case 3:
                System.out.println("Бренд обуви: Нёман");break;
        }
    }
}
