package christmas.date;

public class OrderDate {
    public static final int START_DATE = 1;
    public static final int END_DATE = 31;
    private final int date;
    private final DayOfWeek dayOfWeek;

    public OrderDate(String date) {
        validateNumericType(date);
        validateRange(date);
        this.date = Integer.parseInt(date);
        dayOfWeek = setDayOfWeek(date);
    }

    private void validateNumericType(String date) {
        try {
            Integer.parseInt(date);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] Enter only numeric type");
        }
    }

    private void validateRange(String date) {
        int parseDate = Integer.parseInt(date);
        if (parseDate < START_DATE || parseDate > END_DATE) {
            throw new IllegalArgumentException("[ERROR] Enter Range 1 ~ 31");
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
