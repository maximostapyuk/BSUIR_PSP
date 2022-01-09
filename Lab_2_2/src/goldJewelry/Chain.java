package goldJewelry;

import soft.JObject;

final public class Chain extends JObject {
    private int length;//длина цепочки

    public Chain() {
        super();
        length=0;
        writeName();
    }

    public Chain(int goldContent, float cost, int length) {
        super(goldContent, cost);
        this.length = length;
        writeName();
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    protected void writeName(){
        name="Цепочка";
    }
    @Override
    public String toString(){
        String str = new String();
        str=super.toString()+" Длина цепочки: "+length;
        return str;
    }
    public boolean equals(Object obj){
        if(obj instanceof Chain){
            return this.length==((Chain) obj).length&&
                    this.price==((Chain) obj).price&&
                    this.goldContent==((Chain) obj).goldContent;
        }
        else
            return false;
    }
    @Override
    public int hashCode(){
        int hash=11;
        hash=12*hash+this.length;
        hash=12+hash+this.goldContent;
        return hash;
    }
}
