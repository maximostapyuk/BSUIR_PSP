/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package furniturestore;
import furniturestore.fobject.fixed.Chair;
import furniturestore.fobject.fixed.Table;
import furniturestore.fobject.soft.Sofa;
import furniturestore.fobject.soft.SoftChair;
import furniturestore.order.Order;

public class MainClass {

    
    public static void main(String[] args) {
        // TODO code application logic here
        Order order=new Order();
        Chair chair=new Chair();
        Table table=new Table();
        Sofa sofa=new Sofa();
        SoftChair softChair=new SoftChair();
        sofa.setModel("Пиринея");
        sofa.setCost(420);
        sofa.setPacking("Велюр");
        sofa.setSheathing("Синтепон");
        sofa.setArmset();
        
        chair.setCost(125);
        chair.setMaterial("Дерево");
        chair.setMaxWeight(150);
        chair.setModel("Сенатор");
        
        table.setCost(240);
        table.setForma("круглый");
        table.setMaterial("дерево");
        table.setModel("иллиноис");
        
        softChair.setCost(270);
        softChair.setModel("ирис");
        softChair.setPacking("синтепон");
        softChair.setSheathing("гипюр");
        
        order.addFurniture(sofa);
        order.addFurniture(chair);
        order.addFurniture(table);
        order.addFurniture(softChair);
        
        order.printOrder();
        order.countPrice();
        order.printOrder();
        System.out.println(order.toString());
        
    }
}
