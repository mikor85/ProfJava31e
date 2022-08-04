package lesson1.homework;

// Напишите класс Date с полями year, month, day. Добавиь геттеры и сеттеры, конструктор с 3 параметрами.
// Напишите toString "YYYY-MM-DD" при этом заполняйте нулями месяц и число - пример: 1999-01-09.
// Напишите тест для toString.
// * добавить в класс метод addDay()

public class Date {
    private int year, month, day;

    public Date(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
        if (!checkDate()) {
            System.out.println(this + " - Illegal date!");
        }

    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        if (!checkDate()) {
            System.out.println(this + " - Illegal date!");
        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
        if (!checkDate()) {
            System.out.println(this + " - Illegal date!");
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
        if (!checkDate()) {
            System.out.println(this + " - Illegal date!");
        }
    }

    @Override
    public String toString() {
        return String.format("%d-%02d-%02d", year, month, day);
    }

    // Methods
    private boolean isLeapYear() {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    private boolean checkDate() {
        if (isLeapYear() && month == 2 && day == 29)
            return true;
        if (month == 2 && (day == 30 || day == 29))
            return false;
        if (month >= 1 && month <= 12 && day >= 1 && day <= 30)
            return true;
        if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && day == 31)
            return true;
        return false;
    }


    public void addDay() {
        if (day == 31 && (month == 1 || month == 3 || month == 5 ||
                month == 7 || month == 8 || month == 10 || month == 12)) {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        } else if (day == 30 && (month == 4 || month == 6 || month == 9 || month == 11)) {
            day = 1;
            month++;
        } else if (isLeapYear()) {
            if (month == 2 && day == 28) {
                day++;
            } else if (day == 29) {
                day = 1;
                month++;
            }
        } else {
            day++;
        }
    }

    public static void main(String[] args) {
        Date d1 = new Date(2020, 2, 28);
        System.out.println(d1);
        d1.addDay();
        System.out.println(d1);
    }
}
