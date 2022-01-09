package shoesTypes;

import main.Shoes;

//Создайте класс «Босоножки» производный от «Обувь» содержит дополнительную информацию:
//     открытость (сильно или нет).
public class Sandals extends Shoes {
    private boolean openness;//true - сильно

    public Sandals() {
        super();
        openness = true;
    }

    public Sandals(int size, String manufacturer, String color, int brandID, boolean openness) {
        super(size, manufacturer, color, brandID);
        this.openness = openness;
    }

    public void printInfoSandals(){
        super.printInfo();
        if(this.openness)
            System.out.println("Сильно открытые");
        else
            System.out.println("Закрытые");
        System.out.println("*************************************");
    }
    @Override
    protected void brand(){
        switch (this.brandID){
            case 1:
                System.out.println("Бренд обуви: La Grange");break;
            case 2:
                System.out.println("Бренд обуви: Gloria");break;
            case 3:
                System.out.println("Бренд обуви: Steel");break;
        }
    }
}
