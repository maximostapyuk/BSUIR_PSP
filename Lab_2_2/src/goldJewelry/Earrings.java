package goldJewelry;

import soft.JObject;

final public class Earrings extends JObject {
    private String claspType;//тип застежки

    public Earrings() {
        super();
        claspType = new String();
        writeName();
    }

    public Earrings(int goldContent, float cost, String claspType) {
        super(goldContent, cost);
        this.claspType = claspType;
        writeName();
    }

    public void setClaspType(String claspType) {
        this.claspType = claspType;
    }

    @Override
    protected void writeName(){
        name="Серьги";
    }
    @Override
    public String toString(){
        String str = new String();
        str=super.toString()+" Тип застёжки: "+claspType;
        return str;
    }
    public boolean equals(Object obj){
        if(obj instanceof Earrings){
            return this.claspType==((Earrings) obj).claspType&&
                    this.price==((Earrings) obj).price&&
                    this.goldContent==((Earrings) obj).goldContent;
        }
        else
            return false;
    }
}
