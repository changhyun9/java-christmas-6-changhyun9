package christmas.date;

public enum DayOfWeek {
    THURSDAY("평일"),
    FRIDAY("주말"),
    SATURDAY("주말"),
    SUNDAY("평일"),
    MONDAY("평일"),
    TUESDAY("평일"),
    WEDNESDAY("평일");

    private String dayOfWeek;

    DayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}
