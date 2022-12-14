package hust.soict.hedspi.aims.utils;

import java.time.LocalDate;
import java.util.*;

public class MyDate {

    private static final int MIN_YEAR  = 1;
    private static final int MAX_YEAR  = 9999;

    private static final int MIN_MONTH = 1;
    private static final int MAX_MONTH = 12;

    private int year;
    private int month;
    private int day;

    private String[] strMonths    = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"
            ,"Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    private String[] strFullMonths = {"January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December"};

    private String[] strDays = {"1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th", "9th", "10th",
            "11th", "12th", "13th", "14th", "15th", "16th", "17th", "18th", "19th", "20th",
            "21st", "22nd", "23rd", "24th", "25th", "26th", "27th", "28th", "29th", "30th", "31st"};

    private static final int[] daysInMonths            = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static final int[] nonLeapYearMonthNumbers = {0, 3, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};
    private static final int[] leapYearMonthNumbers    = {6, 2, 3, 6, 1, 4, 6, 2, 5, 0, 3, 5};

    public MyDate() {
        super();
        LocalDate currentDate = LocalDate.now();
        this.setDate(currentDate.getYear(), currentDate.getMonthValue(), currentDate.getDayOfMonth());
    }

    public MyDate(int year, int month, int day) {
        super();
        this.setDate(year, month, day);
    }

    public MyDate(String  day,  String  month, String year) {
        super();
        switch (day) {
            case "first" -> this.setDay(1);
            case "second" -> this.setDay(2);
            case "third" -> this.setDay(3);
            case "fourth" -> this.setDay(4);
            case "fifth" -> this.setDay(5);
            case "sixth" -> this.setDay(6);
            case "seventh" -> this.setDay(7);
            case "eighth" -> this.setDay(8);
            case "ninth" -> this.setDay(9);
            case "tenth" -> this.setDay(10);
            case "eleventh" -> this.setDay(11);
            case "twelfth" -> this.setDay(12);
            case "thirteenth" -> this.setDay(13);
            case "fourteenth" -> this.setDay(14);
            case "fifteenth" -> this.setDay(15);
            case "sixteenth" -> this.setDay(16);
            case "seventeenth" -> this.setDay(17);
            case "eighteenth" -> this.setDay(18);
            case "nineteenth" -> this.setDay(19);
            case "twentieth" -> this.setDay(20);
            case "twenty first" -> this.setDay(21);
            case "twenty second" -> this.setDay(22);
            case "twenty third" -> this.setDay(23);
            case "twenty fourth" -> this.setDay(24);
            case "twenty fifth" -> this.setDay(25);
            case "twenty sixth" -> this.setDay(26);
            case "twenty seventh" -> this.setDay(27);
            case "twenty eighth" -> this.setDay(28);
            case "twenty ninth" -> this.setDay(29);
            case "thirtieth" -> this.setDay(30);
            case "thirty first" -> this.setDay(31);
            default -> {
            }
        }

        switch (month) {
            case "January" -> this.setMonth(1);
            case "February" -> this.setMonth(2);
            case "March" -> this.setMonth(3);
            case "April" -> this.setMonth(4);
            case "May" -> this.setMonth(5);
            case "June" -> this.setMonth(6);
            case "July" -> this.setMonth(7);
            case "August" -> this.setMonth(8);
            case "September" -> this.setMonth(9);
            case "October" -> this.setMonth(10);
            case "November" -> this.setMonth(11);
            case "December" -> this.setMonth(12);
            default -> {
            }
        }

        String[] words = year.split("\\s+");
        if (words.length != 2) {
            System.out.println("Wrong!");
        } else {
            this.setYear((int)(getNumber(words[0]) * 100 + getNumber(words[1])));
        }
    }

    public static int getNumber(String num) {
        return switch (num) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;

            case "nineteen" -> 19;
            case "twenty" -> 20;
            case "twenty-one" -> 21;
            case "twenty-two" -> 22;
            default -> -1;
        };
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static int getMonthLastDay(int year, int month) {
        return daysInMonths[month-1] + (isLeapYear(year) && month == 2 ? 1 : 0 );
    }

    public static boolean isValidDate(int year, int month, int day) {
        return (MIN_YEAR  <= year   && year  <= MAX_YEAR)
                && (MIN_MONTH <= month  && month <= MAX_MONTH)
                && (1         <= day    && day   <= getMonthLastDay(year, month));
    }

    public int getYear() {
        return this.year;
    }

    public int getMonth() {
        return this.month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDate(int year, int month, int day) {
        if (!isValidDate(year, month, day)) {
            throw new IllegalArgumentException("Invalid year, month, or day!");
        }
        this.year  = year;
        this.month = month;
        this.day   = day;
    }

    public void setYear(int year) {
        if (year < MIN_YEAR || year > MAX_YEAR) {
            throw new IllegalArgumentException("Invalid year!");
        }
        this.year = year;
    }

    public void setMonth(int month) {
        if (month < MIN_MONTH || month > MAX_MONTH) {
            throw new IllegalArgumentException("Invalid month!");
        }
        this.month = month;
    }

    public void setDay(int day) {
        if (1 > day || day > getMonthLastDay(this.year, this.month)) {
            throw new IllegalArgumentException("Invalid day!");
        }
        this.day = day;
    }

    public void print() {
        System.out.print(strFullMonths[this.getMonth() - 1] + " ");
        System.out.print(strDays[this.getDay() - 1] + " ");
        System.out.println(this.getYear());
    }

    public void printFormat(String format) {
        if ("yyyy-MM-dd".equals(format)) {
            System.out.println(this.getYear() + "-" + (this.getMonth() < 10 ? "0" : "") + this.getMonth() + "-" +
                    (this.getDay() < 10 ? "0" : "") + this.getYear());
        }
        if ("d/M/yyyy".equals(format)) {
            System.out.println(this.getDay() + "/" + this.getMonth() + "/" + this.getYear());
        }
        if ("dd-MMM-yyy".equals(format)) {
            System.out.println((this.getDay() < 10 ? "0" : "") + this.getDay() + "-" +
                    strMonths[this.getMonth() - 1] + "-" + this.getYear());
        }
        if ("MMM d yyyy".equals(format)) {
            System.out.println(strMonths[this.getMonth() - 1] + " " + this.getDay() + " " + this.getYear());
        }
        if ("MM-dd-yyyy".equals(format)) {
            System.out.println((this.getMonth() < 10 ? "0" : "") + this.getMonth() + "-" +
                    (this.getDay() < 10 ? "0" : "") + this.getYear() + "-" + this.getYear());
        }
    }
}
