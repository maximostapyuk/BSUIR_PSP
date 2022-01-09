/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturestore.order;
import furniturestore.PriceInterface;
import furniturestore.fobject.FObject;
import java.util.*;

public class Order implements PriceInterface{
    
    private List<FObject> furnitureColl;
    private int cost;
    private int price;
    private static int orderNum=0;
    
    public Order()
    {
        furnitureColl = new ArrayList<FObject> ();
        orderNum=orderNum+1;
    }
    
    public void addFurniture(FObject obj)
    {
        furnitureColl.add(obj);
    }
    
    public void printOrder()
    {
        int i=1;
        Iterator it=furnitureColl.iterator();
        System.out.println("=================================================");
        while(it.hasNext())
        {
            System.out.println(i+")"+(it.next()).toString());
            i=i+1;
        }
        System.out.println();
        System.out.println("Себестоимость заказа:"+cost+" Цена заказа:"+price);
        System.out.println("=================================================");
    }
    
    
    @Override
    protected void finalize()
    {
        try {
            super.finalize();
        } catch (Throwable ex) {
          System.err.println("Ошибка при удалении объекта");  
        }
        orderNum=orderNum-1;
    }

    @Override
    public int countPrice() {
        int tempPrice=0, tempCost=0;
        Iterator it=furnitureColl.iterator();
        FObject obj;
        while(it.hasNext())
        {
           obj=(FObject)it.next();
           tempCost=tempCost+obj.getCost();
           tempPrice=tempPrice+obj.getPrice();
        }
        cost=tempCost;
        price=tempPrice;
        return tempPrice;
    }
    
    
}
