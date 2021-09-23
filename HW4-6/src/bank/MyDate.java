package bank;

/**
 * @author Negin Mousavi
 */
public class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public MyDate nextDay() {
        this.day += 1;
        if (this.month < 7) {
            if (this.day - 1 == 31) {
                this.day = 1;
                this.month += 1;
            }
        } else {
            if (this.day - 1 == 30) {
                this.day = 1;
                if (this.month == 12) {
                    this.year += 1;
                    this.month = 1;
                } else
                    this.month += 1;
            }
        }
        return this;
    }

    public String nameOfMonth(int numberOfMonth) {
        String nameOfMonth;
        switch (numberOfMonth) {
            case 1:
                nameOfMonth = "Farvardin";
                break;
            case 2:
                nameOfMonth = "Ordibehesht";
                break;
            case 3:
                nameOfMonth = "Khordad";
                break;
            case 4:
                nameOfMonth = "Tir";
                break;
            case 5:
                nameOfMonth = "Mordad";
                break;
            case 6:
                nameOfMonth = "Shahrivar";
                break;
            case 7:
                nameOfMonth = "Mehr";
                break;
            case 8:
                nameOfMonth = "Aban";
                break;
            case 9:
                nameOfMonth = "Azar";
                break;
            case 10:
                nameOfMonth = "Dey";
                break;
            case 11:
                nameOfMonth = "Bahman";
                break;
            case 12:
                nameOfMonth = "Esfand";
                break;
            default:
                nameOfMonth = "invalid";
        }
        return nameOfMonth;
    }

    @Override
    public String toString() {
        return year +
                " " + nameOfMonth(month) +
                " " + day;
    }

    public boolean validDate(int year, int month, int day) {
        boolean valid = false;
        if (year <= 9999 && year >= 1) {
            if (month >= 1 && month <= 6) {
                if (day >= 1 && day <= 31) {
                    valid = true;
                }
            }
            if (month >= 7 && month <= 11) {
                if (day >= 1 && day <= 30) {
                    valid = true;
                }
            }
            if (month == 12) {
                if (day >= 1 && day <= 29) {
                    valid = true;
                }
            }

        }
        return valid;
    }

    public int getMonthLastDay(int month) {
        int lastday = 0;
        if (month >= 1 && month <= 6) {
            lastday = 31;
        }
        if (month >= 7 && month <= 11) {
            lastday = 30;
        }
        if (month == 12) {
            lastday = 29;
        }
        return lastday;
    }
}