package goldJewelry;

import soft.JObject;

final public class Ring extends JObject {
    private float size;

    public Ring() {
        super();
        size=0;
        writeName();
    }

    public Ring(int goldContent, float cost, float size) {
        super(goldContent, cost);
        this.size = size;
        writeName();
    }

    public void setLength(float size) {
        this.size = size;
    }

    @Override
    protected void writeName(){
        name="Кольцо";
    }
    @Override
    public String toString(){
        String str = new String();
        str=super.toString()+" Размер кольца: "+size;
        return str;
    }
    public boolean equals(Object obj){
        if(obj instanceof Ring){
            return this.size==((Ring) obj).size&&
                    this.price==((Ring) obj).price&&
                    this.goldContent==((Ring) obj).goldContent;
        }
        else
            return false;
    }
    @Override
    public int hashCode(){
        int hash = 5;
        hash = 9*hash+this.goldContent;
        return  hash;
    }
}
