package christmas.domain.order;

public class OrderDate {
    public static final int START_DATE = 1;
    public static final int END_DATE = 31;
    private int day;

    public OrderDate(String date) {
        validateNumericType(date);
        validateRange(date);
        this.day = Integer.parseInt(date);
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

}
