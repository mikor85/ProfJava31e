package lesson3.homework;

public class Day {
    private Weekday weekday;

    public Day(Weekday weekday) {
        this.weekday = weekday;
    }

    public boolean isWeekDay() {
        return switch (weekday) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> true;
            default -> false;
        };
    }

    public boolean isWeekEnd() {
        return switch (weekday) {
            case SATURDAY, SUNDAY -> true;
            default -> false;
        };
    }
}
