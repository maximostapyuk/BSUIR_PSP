package main;
//Создайте класс «Обувь», содержащую следующую информацию: размер, производитель, цвет.
// Предусмотреть get методы. Метод класса «Бренд», который потом будут переопределять производные классы.
public class Shoes {
    protected int size;
    protected String manufacturer;
    protected String color;
    protected int brandID;

    public Shoes() {
        size=0;
        manufacturer=new String();
        color=new String();
        brandID=1;
    }

    public Shoes(int size, String manufacturer, String color,int brandID) {
        this.size = size;
        this.manufacturer = manufacturer;
        this.color = color;
        this.brandID=brandID;
    }

    public float getSize() {
        return size;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getColor() {
        return color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void printInfo(){
        System.out.println("*************************************");
        System.out.println("Размер: " + size+" Производитель: "+ manufacturer+" Цвет: "+color);
        this.brand();
    }
    protected void brand(){
        System.out.println("Бренд обуви: Марко");
    }


}
