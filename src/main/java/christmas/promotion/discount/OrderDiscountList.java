package christmas.promotion.discount;

import java.util.ArrayList;
import java.util.List;

public class OrderDiscountList {
    private final List<OrderDiscount> orderDiscountList;

    public OrderDiscountList() {
        this.orderDiscountList = new ArrayList<>();
    }

    public void insertOrderDiscount(OrderDiscount orderDiscount) {
        orderDiscountList.add(orderDiscount);
    }

    public List<OrderDiscount> getOrderDiscountList() {
        return orderDiscountList;
    }

    public int getAllDiscountPrice() {
        int allDiscountPrice=0;
        for (OrderDiscount orderDiscount : orderDiscountList) {
            allDiscountPrice += orderDiscount.getDiscountPrice();
        }
        return allDiscountPrice;
    }
}
