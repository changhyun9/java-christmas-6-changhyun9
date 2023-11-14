package christmas.order;

import christmas.date.OrderDate;
import christmas.menu.OrderMenus;

public class Order {
    private final OrderDate orderDate;
    private final OrderMenus orderMenus;

    public Order(String inputOrderDate, String inputOrderMenus) {
        this.orderDate = new OrderDate(inputOrderDate);
        this.orderMenus = new OrderMenus(inputOrderMenus);
    }

    public int getOrderDate() {
        return orderDate.getDate();
    }

    public String getOrderDateOfWeek() {
        return orderDate.getDayOfWeek();
    }

    public int getOrderPrice() {
        return orderMenus.getTotalPrice();
    }
}
