package shoeseTypes;

import templates.SObject;
import templates.Shoes;

public class Boots implements Shoes, SObject {
    private int size;
    private String manufacturer;
    private String color;
    private int brandID;
    private String soleTyp e;
    private String companyManufacturer;
    private int heelSize;
    private boolean type;//true-демисезонные

    public Boots(int size, String manufacturer, String color, int heelSize, boolean type,int brandID) {
        this.size = size;
        this.manufacturer = manufacturer;
        this.color = color;
        this.brandID=brandID;
        this.heelSize = heelSize;
        this.type = type;
    }

    public Boots() {
        size=0;
        manufacturer=new String();
        color=new String();
        brandID=1;
        heelSize=0;
        type = true;
    }


    @Override
    public void printInfo() {
        System.out.println("*************************************");
        System.out.println("Размер: " + size+" Производитель: "+ manufacturer+" Цвет: "+color);
        this.brand();
        System.out.println("Размер каблука: "+heelSize+" см");
        if(this.type)
            System.out.println("Демисезонные");
        else
            System.out.println("Зимние");
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
