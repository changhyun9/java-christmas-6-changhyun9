package christmas.menu;

import christmas.order.menu.OrderMenus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderMenusTest {

    OrderMenus orderMenus;

    @DisplayName("중복되지 않은 메뉴를 리스트에 추가한다")
    @Test
    void insertMenuNonDuplicated() {
        orderMenus = new OrderMenus("해산물파스타-1,티본스테이크-3");

        Assertions.assertThat(orderMenus.getSize()).isEqualTo(2);

    }

    @DisplayName("중복된 메뉴를 리스트에 추가하면 예외가 발생한다")
    @Test
    void insertMenuByDuplicate() {

        Assertions.assertThatThrownBy(() -> new OrderMenus("해산물파스타-1,해산물파스타-3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 주문 금액을 반환한다")
    @Test
    void getTotalPrice() {
        orderMenus = new OrderMenus("해산물파스타-1,티본스테이크-2,타파스-3");
        Assertions.assertThat(orderMenus.getTotalPrice()).isEqualTo(161_500);
    }

    @DisplayName("총 주문 수량이 20개를 넘으면 예외가 발생한다")
    @Test
    void orderMenuByMoreThan20() {

        Assertions.assertThatThrownBy(() -> new OrderMenus("해산물파스타-4,티본스테이크-9,타파스-8"))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("음료만 주문한 경우 예외가 발생한다")
    @Test
    void orderMenuByOnlyBeverage() {
        Assertions.assertThatThrownBy(() -> new OrderMenus("제로콜라-3,샴페인-8"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
