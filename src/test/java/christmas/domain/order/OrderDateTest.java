package christmas.domain.order;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OrderDateTest {

    @DisplayName("1 ~ 31 사이의 숫자만 입력해야 한다")
    @Test
    void enterNumberByRange() {
        Assertions.assertThatThrownBy(() -> new OrderDate("34"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자만 입력이 가능하다")
    @Test
    void enterOnlyNumber() {
        Assertions.assertThatThrownBy(() -> new OrderDate("1일"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
