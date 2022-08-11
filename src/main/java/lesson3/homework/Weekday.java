package lesson3.homework;

public enum Weekday {
    MONDAY(1), TUESDAY(2), WEDNESDAY(3),
    THURSDAY(4), FRIDAY(5),
    SATURDAY(6), SUNDAY(7);

    private int weekdayValue;

    Weekday(int weekdayValue) {
        this.weekdayValue = weekdayValue;
    }

    public int getWeekdayValue() {
        return weekdayValue;
    }

    public boolean isWeekDay() {
        return switch (weekdayValue) {
            case 1, 2, 3, 4, 5 -> true;
            default -> false;
        };
    }

    public boolean isWeekEnd() {
        return switch (weekdayValue) {
            case 6, 7 -> true;
            default -> false;
        };
    }
}
