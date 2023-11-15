package christmas.ui;

import christmas.order.Order;

import christmas.order.date.OrderDate;
import christmas.order.menu.OrderMenu;
import christmas.order.menu.OrderMenus;
import christmas.promotion.Promotion;
import christmas.promotion.discount.Discount;
import christmas.promotion.discount.OrderDiscount;
import christmas.promotion.event.Event;
import christmas.promotion.event.EventMenu;
import java.text.DecimalFormat;
import java.util.List;

public class OutputView {
    private final Promotion promotion;
    private final Order order;

    public OutputView(Order order) {
        this.order = order;
        OrderDate orderDate = order.getOrderDate();
        OrderMenus orderMenus = order.getOrderMenus();
        this.promotion = new Promotion(orderDate, orderMenus);
    }

    public void printEvent() {
        printOrderMenus();
        printOrderPrice();
        printEventMenu();
        printAllPromotion();
        printPromotionPrice();
        printPayPrice();
        printEventBadge();
    }

    private void printOrderMenus() {
        System.out.println("<주문 메뉴>");
        OrderMenus orderMenus = order.getOrderMenus();
        List<OrderMenu> orderMenuList = orderMenus.getOrderMenus();
        for (OrderMenu orderMenu : orderMenuList) {
            System.out.println(orderMenu.getMenuName() +" "+orderMenu.getQuantity() +"개");
        }
        System.out.println();
    }

    private void printOrderPrice() {
        System.out.println("<할인 전 총주문 금액>");
        OrderMenus orderMenus = order.getOrderMenus();
        int totalPrice = orderMenus.getTotalPrice();
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println(df.format(totalPrice) + "원\n");
    }

    private void printEventMenu() {
        System.out.println("<증정 메뉴>");
        Event event = promotion.getEvent();
        EventMenu eventMenu = event.getEventMenu();
        String eventMenuName = eventMenu.getEventMenuName();
        int quantity = eventMenu.getQuantity();
        if(hasEventMenu()){
            System.out.println(eventMenuName +" "+quantity+"개\n");
        }
        if(!hasEventMenu()){
            System.out.println(eventMenuName + "\n");
        }
    }

    private void printAllPromotion() {
        System.out.println("<혜택 내역>");
        Discount discount = promotion.getDiscount();
        List<OrderDiscount> orderDiscounts = discount.AllDiscount();
        if(orderDiscounts.size() == 0){
            System.out.println("없음");
        }
        for (OrderDiscount orderDiscount : orderDiscounts) {
            String discountName = orderDiscount.getDiscountName();
            int discountPrice = orderDiscount.getDiscountPrice();
            System.out.println(discountName + ": -" + discountPrice +"원");
        }
        if (hasEventMenu()) {
            System.out.println("증정 이벤트: -25,000원");
        }
    }

    private void printPromotionPrice() {
        int promotionPrice = promotion.getPromotionPrice();
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println("\n<총혜택 금액>");
        if(promotionPrice > 0){
            System.out.println("-" + df.format(promotionPrice) + "원\n");
        }
        if(promotionPrice <= 0){
            System.out.println("0원\n");
        }

    }

    private boolean hasEventMenu() {
        Event event = promotion.getEvent();
        EventMenu eventMenu = event.getEventMenu();
        String eventMenuName = eventMenu.getEventMenuName();
        if (eventMenuName.equals("없음")) {
            return false;
        }
        return true;
    }

    private void printPayPrice() {
        System.out.println("<할인 후 예상 결제 금액>");
        int orderTotalPrice = order.getOrderTotalPrice();
        Discount discount = promotion.getDiscount();
        int discountPrice = discount.getDiscountPrice();
        int payPrice = orderTotalPrice - discountPrice;
        DecimalFormat df = new DecimalFormat("#,###");
        System.out.println(df.format(payPrice) + "원\n");
    }

    private void printEventBadge() {
        System.out.println("<12월 이벤트 배지>");
        Event event = promotion.getEvent();
        String badge = event.getBadge();
        System.out.println(badge);
    }


}
