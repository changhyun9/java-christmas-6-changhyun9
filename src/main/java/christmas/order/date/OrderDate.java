package christmas.order.date;

public class OrderDate {
    public static final int START_DATE = 1;
    public static final int END_DATE = 31;
    private final int date;
    private final DayOfWeek dayOfWeek;

    public OrderDate(String date) {
        try {
            validateNumericType(date);
            validateRange(date);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        this.date = Integer.parseInt(date);
        dayOfWeek = setDayOfWeek(date);
    }

    private void validateNumericType(String date) {
        try {
            int parseDate = Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private void validateRange(String date) {
        int parseDate = Integer.parseInt(date);
        if (parseDate < START_DATE || parseDate > END_DATE) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private DayOfWeek setDayOfWeek(String date) {
        int day = checkDayOfWeek(Integer.parseInt(date));
        DayOfWeek[] values = DayOfWeek.values();
        return values[day];
    }

    private int checkDayOfWeek(int date){
        return date % 7;
    }

    public int getDate() {
        return date;
    }

    public String getDayOfWeek() {
        return dayOfWeek.getDayOfWeek();
    }

}
