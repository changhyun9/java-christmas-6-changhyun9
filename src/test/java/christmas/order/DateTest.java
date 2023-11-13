package christmas.order;

import christmas.date.Date;
import christmas.date.DayOfWeek;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DateTest {

    @DisplayName("1 ~ 31 사이의 숫자만 입력해야 한다")
    @Test
    void enterNumberByRange() {
        Assertions.assertThatThrownBy(() -> new Date("34"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자만 입력이 가능하다")
    @Test
    void enterOnlyNumber() {
        Assertions.assertThatThrownBy(() -> new Date("1일"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자로 날을 입력받으면, 요일이 저장된다")
    @Test
    void checkDayOfWeek() {
        Date orderDate = new Date("1");
        DayOfWeek dayOfWeek = orderDate.getDayOfWeek();
        Assertions.assertThat(dayOfWeek).isEqualTo(DayOfWeek.FRIDAY);
    }
}
