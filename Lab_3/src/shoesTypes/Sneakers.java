package shoesTypes;
// Создайте класс «Кроссовки» производный от «Обувь» содержит дополнительную информацию:
//     тип_подошвы, фирма_производитель.
import main.Shoes;

public class Sneakers extends Shoes {
    private String soleType;
    private String companyManufacturer;

    public Sneakers(int size, String manufacturer, String color,
                    int brandID, String soleType) {
        super(size, manufacturer, color, brandID);
        this.soleType = soleType;
        this.companyManufacturer = setCompanyManufacturer();
    }

    public Sneakers() {
        super();
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
    public void printInfoSneakers(){
        super.printInfo();
        System.out.println("Тип подошвы: "+soleType);
        System.out.println("*************************************");
    }

    @Override
    protected void brand(){
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
