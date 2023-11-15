package christmas.promotion;

import christmas.order.date.OrderDate;
import christmas.order.menu.OrderMenus;
import christmas.promotion.discount.Discount;
import christmas.promotion.event.Event;
import christmas.promotion.event.EventMenu;

public class Promotion {
    private final Discount discount;
    private final Event event;

    public Promotion(OrderDate orderDate, OrderMenus orderMenus) {
        this.discount = new Discount(orderDate, orderMenus);
        int orderTotalPrice = orderMenus.getTotalPrice();
        int discountTotalPrice = discount.getDiscountPrice();
        this.event = new Event(orderTotalPrice, discountTotalPrice);
    }

    public Event getEvent() {
        return event;
    }

    public Discount getDiscount() {
        return discount;
    }

    public int getPromotionPrice() {
        int discountPrice = discount.getDiscountPrice();
        EventMenu eventMenu = event.getEventMenu();
        String eventMenuName = eventMenu.getEventMenuName();
        if(!eventMenuName.equals("없음")){
            return discountPrice + 25000;
        }
        return discountPrice;
    }
}
