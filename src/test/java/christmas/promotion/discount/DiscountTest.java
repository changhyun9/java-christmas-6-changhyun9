package christmas.promotion.discount;

import christmas.order.date.OrderDate;
import christmas.order.menu.OrderMenus;
import christmas.promotion.discount.Discount;
import christmas.promotion.discount.OrderDiscount;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DiscountTest {

    @DisplayName("날짜, 요일에 따라 적용되는 할인이 다르다")
    @Test
    void discountChristmasDay() {
        Discount discount = new Discount(new OrderDate("3"), new OrderMenus("티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1"));
        List<OrderDiscount> orderDiscounts = discount.AllDiscount();
        for (OrderDiscount orderDiscount : orderDiscounts) {
            System.out.println(orderDiscount.getDiscountName());
            System.out.println(orderDiscount.getDiscountPrice());
        }
    }
}
