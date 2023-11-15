package christmas.promotion.event;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EventTest {

    Event event = new Event(142_000, 5300);

    @DisplayName("할인 전 주문금액이 12만원 이상이면 샴페인 증정")
    @Test
    void eventPresentationByOrderPrice() {
        EventMenu eventMenu = event.getEventMenu();
        Assertions.assertThat(eventMenu.getEventMenuName()).isEqualTo("샴페인");
        Assertions.assertThat(eventMenu.getEventMenuPrice()).isEqualTo(25000);
        Assertions.assertThat(eventMenu.getQuantity()).isEqualTo(1);
    }

    @DisplayName("총 혜택 금액에 따른 뱃지 증정")
    @Test
    void eventBadgeByPromotionPrice() {
        String badge = event.getBadge();
        Assertions.assertThat(badge).isEqualTo("별");
    }
}