/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturestore.fobject;
import furniturestore.PriceInterface;

abstract public class FObject implements PriceInterface{
   protected String fName;//Название предмета мебели
    protected String fModel;//Модель мебели
    protected int fCost;//Себестоимость предмета мебели
    protected int fPrice;//Цена предмета мебели
    public FObject()//конструктор класса
    { fName=new String();
        fModel=new String();
        fCost=0;
        fPrice=0;}
    abstract protected void generateName();//абстрактная функция
    public void setModel(String model)//установка значений
    {
        fModel=model;
    }
    protected void setPrice()
    {
        fPrice=countPrice();
    }
    public void setPrice(int price)
    {
        fPrice=price;
    }
    
    public void setCost(int cost)
    {
        fCost=cost;
        setPrice();
    }
    public int getPrice()
    {
        return fPrice;
    }
    public int getCost()
    {
        return fCost;
    }
     @Override
      public int countPrice()//Подсчёт отпускной цены на основе себестоимости
      {
          int price;
          price=(int) ((fCost*1.2)*1.2);
          return price;
      }
     
     @Override
    public String toString()
    {
        String str=new String();
        str=fName+"_"+fModel+"_себестоимость:"+fCost+"у.е._Цена:"+fPrice+"у.е.";
        return str;
    }
}
