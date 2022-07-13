import java.util.ArrayList;

/**
 * Abstraction of a date with day, month and year.
 */
public class Date {
    private final int day;
    private final int month;
    private final int year;

    private static boolean isValidDay(int day, int month) {
        ArrayList<Integer> arrMonth30 = new ArrayList<Integer>(5);

        arrMonth30.add(2);
        arrMonth30.add(4);
        arrMonth30.add(6);
        arrMonth30.add(9);
        arrMonth30.add(11);

        if (day < 1 || day > 31) {
            return false;
        }

        if (arrMonth30.contains(month) && day > 30) {
            return false;
        }

        return !(month == 2 && day > 29);
    }

    /**
     * Constructor of the object.
     *
     * @param day the day
     * @param month the month
     * @param year the year
     */
    public Date(int day, int month, int year) {
        if (isValidDay(day, month)) {
            this.day = day;
        } else {
            throw new IllegalArgumentException("Day must be in [1,31]");
        }

        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month must be in [1,12]");
        }

        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Year must be in [1,9999]");
        }

        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    /**
     * Check if a given year is a leap year.
     *
     * @param year the year
     * @return true if it is a leap year, false otherwise
     */
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else if (year % 400 != 0) {
            return false;
        }

        return true;
    }

    /**
     * Check if the current date precedes a given date.
     *
     * @param date the date
     * @return true if it precedes, false otherwise
     */
    public boolean before(Date date) {
        if (this.year < date.year) {
            return true;
        } else if (this.year > date.year) {
            return false;
        } else {
            if (this.month < date.month) {
                return true;
            } else if (this.month > date.month) {
                return false;
            } else {
                return this.day < date.day;
            }
        }
    }

    /**
     * Check if the current date follows a given date.
     *
     * @param date the date
     * @return true if it follows, false otherwise
     */
    public boolean after(Date date) {
        if (this.year > date.year) {
            return true;
        } else if (this.year < date.year) {
            return false;
        } else {
            if (this.month > date.month) {
                return true;
            } else if (this.month < date.month) {
                return false;
            } else {
                return this.day > date.day;
            }
        }
    }
}
