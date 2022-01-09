package shoeseTypes;

import templates.Sandals;

public class FlipFlop extends Sandals {
    private int size;
    private String manufacturer;
    private String color;
    private int brandID;
    private boolean openness;//true - сильно
    private int heelSize;

    public FlipFlop() {
        size=0;
        manufacturer=new String();
        color=new String();
        brandID=1;
        heelSize=0;
        openness = true;
    }

    public FlipFlop(int size, String manufacturer, String color,
                    int brandID, boolean openness, int heelSize) {
        this.size = size;
        this.manufacturer = manufacturer;
        this.color = color;
        this.brandID = brandID;
        this.openness = openness;
        this.heelSize = heelSize;
    }

    @Override
    public void printInfo() {
        System.out.println("*************************************");
        System.out.println("Размер: " + size+" Производитель: "+ manufacturer+" Цвет: "+color);
        this.brand();
        System.out.println("Размер каблука: "+heelSize+" см");
        if(this.openness)
            System.out.println("Открытые");
        else
            System.out.println("Закрытые");
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
