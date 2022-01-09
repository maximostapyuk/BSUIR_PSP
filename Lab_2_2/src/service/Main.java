package service;

import goldJewelry.Chain;
import goldJewelry.Earrings;
import goldJewelry.Ring;
import jewelryStore.Order;

public class Main {
    public static void main(String[] args) {
        Order order=new Order();

        Chain chain=new Chain(875, (float) 326.7,29);
        Earrings earrings=new Earrings(916,(float) 647.3,"Булавка");
        Ring ring=new Ring(585,(float) 457,(float) 29.5);

        order.addJewelry(chain);
        order.addJewelry(earrings);
        order.addJewelry(ring);

        order.countPrice();
        order.printOrder();
    }
}
