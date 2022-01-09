package jewelryStore;

import service.Jewelry;
import soft.JObject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Order implements Jewelry {
    private List<JObject> jewelryCollection;
    private  float cost;
    private  float price;
    private static int orderNum=0;

    public Order() {
        jewelryCollection = new ArrayList<JObject>();
        orderNum+=1;
    }

    public void addJewelry(JObject obj){
        jewelryCollection.add(obj);
    }

    public void printOrder(){
        int i=1;
        Iterator it = jewelryCollection.iterator();
        System.out.println("***************************************");
        while (it.hasNext()){
            System.out.println(i+". "+(it.next()).toString());
            i+=1;
        }
        System.out.println();
        System.out.println("Коллекция ювелирных изделий:");
        System.out.println("Себестоимость: "+cost);
        System.out.println("Цена: "+price);
        System.out.println("Прибыль от продажи: "+ (price-cost));
        System.out.println("***************************************");
    }

    @Override
    public float countPrice(){
        float tmpCost=0,tmpPrice=0;
        Iterator it = jewelryCollection.iterator();
        JObject object;
        while (it.hasNext()){
            object=(JObject) it.next();
            tmpCost+=object.getCost();
            tmpPrice+=object.getPrice();
        }
        cost=tmpCost;
        price=tmpPrice;
        return tmpPrice;
    }
}
