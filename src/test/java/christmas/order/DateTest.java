package christmas.order;

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

    @DisplayName("숫자로 날을 입력받으면, 요일이 저장된다")
    @Test
    void checkDayOfWeek() {
        OrderDate orderDate = new OrderDate("1");
        String dayOfWeek = orderDate.getDayOfWeek();
        Assertions.assertThat(dayOfWeek).isEqualTo("금요일");
    }
}
