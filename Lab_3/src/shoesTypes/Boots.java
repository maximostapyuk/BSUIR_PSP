package shoesTypes;
//  Создайте класс «Сапоги» производный от «Обувь», который содержит дополнительную информацию:
//        размер каблука, тип (демисезонные или зимние).
import main.Shoes;

public class Boots extends Shoes {
    private int heelSize;
    private boolean type;//true-демисезонные

    public Boots(int size, String manufacturer, String color, int heelSize, boolean type,int brandID) {
        super(size, manufacturer, color, brandID);
        this.heelSize = heelSize;
        this.type = type;
    }

    public Boots() {
        super();
        heelSize=0;
        type = true;
    }


    public void printInfoBoots(){
        super.printInfo();
        System.out.println("Размер каблука: "+heelSize+" см");
        if(this.type)
            System.out.println("Демисезонные");
        else
            System.out.println("Зимние");
        System.out.println("*************************************");
    }

    @Override
    protected void brand(){
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
