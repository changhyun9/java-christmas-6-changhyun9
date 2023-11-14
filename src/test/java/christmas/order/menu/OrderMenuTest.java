package christmas.order.menu;

import christmas.order.menu.Menu;
import christmas.order.menu.OrderMenu;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderMenuTest {

    @DisplayName("메뉴명-수량 형식으로 주문해야 한다")
    @Test
    void orderMenuFormat() {
        Assertions.assertThatThrownBy(() -> new OrderMenu("해산물파스타=1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하지 않는 메뉴를 주문하면 예외가 발생한다")
    @Test
    void orderMenuByNonExist() {
        Assertions.assertThatThrownBy(() -> new OrderMenu("페퍼로니피자-1"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("존재하는 메뉴를 주문해야 한다")
    @Test
    void orderMenuExist() {
        OrderMenu menu = new OrderMenu("해산물파스타-2");
        Assertions.assertThat(menu.getMenuName()).isEqualTo(Menu.해산물파스타);
    }

    @DisplayName("단일 메뉴는 1개 이상 주문하지 않으면 예외가 발생한다")
    @Test
    void orderMenuByMoreThan1() {
        Assertions.assertThatThrownBy(() -> new OrderMenu("티본스테이크-0"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메뉴는 20개 이하로 주문 가능하다")
    @Test
    void orderMenuByLessThan20() {
        Assertions.assertThatThrownBy(() -> new OrderMenu("초코케이크-21"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
