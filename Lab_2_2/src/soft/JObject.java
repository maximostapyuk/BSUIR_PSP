package soft;

import service.Jewelry;

abstract public class JObject implements Jewelry {
    protected String name;//название
    protected String material;//материал
    protected int goldContent;//проба
    protected float cost;//себестоимость
    protected  float price;//отпускная цена

    public JObject() {
        name = new String();
        material= "Золото";
        goldContent=925;
        cost=0;
        price=0;
    }

    public JObject(int goldContent, float cost) {
        this.name = new String();
        this.material = "Золото";
        this.goldContent = goldContent;
        this.cost = cost;
        this.price = countPrice();
    }

    abstract  protected void writeName();

    public void setName(String name) {
        this.name = name;
    }

    public void setGoldContent(int goldContent) {
        this.goldContent = goldContent;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public float getCost() {
        return cost;
    }

    public float getPrice() {
        return price;
    }
    @Override
    public float countPrice(){
        float price;
        price= (float) (cost*1.47);
        return price;
    }
    @Override
    public String toString(){
        String str = new String();
        str="Название: "+name+" Материал: "+material+" Проба: "+goldContent+" Цена: "+price+" BYN";
        return  str;
    }
}
