package christmas.promotion.discount;

import christmas.order.date.OrderDate;
import christmas.order.menu.OrderMenus;
import java.util.List;

public class Discount {
    public static final int DISCOUNT_START_DAY = 1;
    public static final int DISCOUNT_END_DAY = 25;
    public static final int ONE_DAY_DISCOUNT_PRICE = 100;
    public static final int BASIC_DISCOUNT_PRICE = 1000;
    private final OrderDiscountList orderDiscountList;

    public Discount(OrderDate orderDate, OrderMenus orderMenus) {
        this.orderDiscountList = new OrderDiscountList();
        int totalPrice = orderMenus.getTotalPrice();
        if (totalPrice >= 10_000) {
            discountChristmasDay(orderDate);
            discountDateOfWeek(orderDate, orderMenus);
            discountSpecial(orderDate);
        }
    }

    private void addDiscountList(OrderDiscount orderDiscount) {
        orderDiscountList.insertOrderDiscount(orderDiscount);
    }

    private void discountChristmasDay(OrderDate orderDate) {
        int date = orderDate.getDate();
        if (DISCOUNT_START_DAY <= date && date <= DISCOUNT_END_DAY) {
            int discountPrice = (date-1) * ONE_DAY_DISCOUNT_PRICE + BASIC_DISCOUNT_PRICE;
            OrderDiscount orderDiscount = new OrderDiscount(DiscountList.크리스마스디데이, discountPrice);
            addDiscountList(orderDiscount);
        }
    }

    private void discountDateOfWeek(OrderDate orderDate, OrderMenus orderMenus) {
        String dayOfWeek = orderDate.getDayOfWeek();
        if(dayOfWeek.equals("주말")){
            int mainQuantity = orderMenus.getMainQuantity();
            int discountPrice = mainQuantity * 2023;
            OrderDiscount orderDiscount = new OrderDiscount(DiscountList.주말할인, discountPrice);
            addDiscountList(orderDiscount);
        }
        if(dayOfWeek.equals("평일")){
            int dessertQuantity = orderMenus.getDessertQuantity();
            int discountPrice = dessertQuantity * 2023;
            OrderDiscount orderDiscount = new OrderDiscount(DiscountList.평일할인, discountPrice);
            addDiscountList(orderDiscount);
        }
    }

    private void discountSpecial(OrderDate orderDate) {
        int date = orderDate.getDate();
        StarDay starDay = StarDay.STAR_DAY;
        boolean containDay = starDay.containDay(date);
        if (containDay){
            OrderDiscount orderDiscount = new OrderDiscount(DiscountList.특별할인, BASIC_DISCOUNT_PRICE);
            addDiscountList(orderDiscount);
        }
    }

    public List<OrderDiscount> AllDiscount() {
        return orderDiscountList.getOrderDiscountList();
    }

    public int getDiscountPrice() {
        return orderDiscountList.getAllDiscountPrice();
    }
}
