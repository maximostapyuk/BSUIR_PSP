package shoeseTypes;

import templates.SObject;
import templates.Shoes;

public class Sneakers implements Shoes, SObject {
    private int size;
    private String manufacturer;
    private String color;
    private int brandID;
    private String soleType;
    private String companyManufacturer;

    public Sneakers(int size, String manufacturer, String color,
                    int brandID, String soleType) {
        this.size = size;
        this.manufacturer = manufacturer;
        this.color = color;
        this.brandID=brandID;
        this.soleType = soleType;
        this.companyManufacturer = setCompanyManufacturer();
    }

    public Sneakers() {
        size=0;
        manufacturer=new String();
        color=new String();
        brandID=1;
        soleType = new String();
        companyManufacturer=setCompanyManufacturer();
    }
    private String setCompanyManufacturer(){
        switch (this.brandID){
            case 1:
                return "Puma";
            case 2:
                return "Adidas";
            case 3:
                return "ASICS";
            default:return null;
        }
    }
    @Override
    public void printInfo(){
        System.out.println("*************************************");
        System.out.println("Размер: " + size+" Производитель: "+ manufacturer+" Цвет: "+color);
        this.brand();
        System.out.println("Тип подошвы: "+soleType);
        System.out.println("*************************************");
    }

    @Override
    public void brand(){
        switch (this.brandID){
            case 1:
                System.out.println("Бренд обуви: Puma");break;
            case 2:
                System.out.println("Бренд обуви: Adidas");break;
            case 3:
                System.out.println("Бренд обуви: ASICS");break;
        }
    }
}
