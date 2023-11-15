package christmas.order;

import christmas.order.date.OrderDate;
import christmas.order.menu.OrderMenus;

public class Order {
    private final OrderDate orderDate;
    private final OrderMenus orderMenus;

    public Order(OrderDate orderDate, OrderMenus orderMenus) {
        this.orderDate = orderDate;
        this.orderMenus = orderMenus;
    }

    public OrderDate getOrderDate() {
        return orderDate;
    }

    public OrderMenus getOrderMenus() {
        return orderMenus;
    }
    public int getOrderTotalPrice(){
        return orderMenus.getTotalPrice();
    }
}
