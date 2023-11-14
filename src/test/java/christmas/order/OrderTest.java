package christmas.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderTest {
    Order order = new Order("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1");

    @DisplayName("날짜를 반환한다")
    @Test
    void returnDate() {
        Assertions.assertThat(order.getOrderDate()).isEqualTo(3);

    }

    @DisplayName("주말 혹은 평일을 반환한다")
    @Test
    void returnDayOfWeek() {
        Assertions.assertThat(order.getOrderDateOfWeek()).isEqualTo("평일");
    }

    @DisplayName("할인 전 총 주문금액을 반환한다")
    @Test
    void returnTotalPriceBeforeDiscount() {
        Assertions.assertThat(order.getOrderPrice()).isEqualTo(142_000);
    }
}
