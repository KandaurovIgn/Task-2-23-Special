package task2233;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int year = getYear();
        int month = getMonth();
        int day = getDay();
        int dayOfWeek = getDayOfWeek(year, month, day);
        boolean dayWeekend = isDayWeekend(dayOfWeek);

        showDayStatus(year, month, day, dayWeekend);
    }

    public static int getDay() {
        while (true) {
            int day = getIntData("Day");
            if (isDataInsideInterval(day, 1, 31) == false)
                System.out.println("Input ERROR! 0 < day < 32");
            else
                return day;
        }
    }

    public static int getMonth() {
        while (true) {
            int month = getIntData("Month");
            if (isDataInsideInterval(month, 1, 12) == false)
                System.out.println("Input ERROR! 0 < Month < 13");
            else
                return month;
        }
    }

    public static int getYear() {
        while (true) {
            int year = getIntData("Year");
            if (isDataInsideInterval(year, 2001, 3000) == false)
                System.out.println("Input ERROR! 2000 < Year < 3001");
            else
                return year;
        }
    }

    public static int getIntData(String request) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input " + request + ":");

        return scanner.nextInt();
    }

    public static boolean isDataInsideInterval(int data, int lowerLimit, int upperLimit) {
        if (data < lowerLimit || data > upperLimit)
            return false;
        return true;
    }

    public static void showDayStatus(int year, int month, int day, boolean dayWeekend) {
        System.out.print(year + "/" + month + "/" + day + " -");
        if (dayWeekend == true)
            System.out.print(" Weekend");
        else
            System.out.print(" Work day");
    }

    public static boolean isDayWeekend(int dayOfWeek) {
        if (dayOfWeek == 0 || dayOfWeek == 6)
            return true;
        return false;
    }

    public static int getDayOfWeek(int year, int month, int day) {
        if (month == 1 || month == 2) {
            year = year - 1;
            month = month + 10;
        } else
            month = month - 2;
        int tempVar = (day + ((31 * month) / 12) + year + (year / 4) - (year / 100) + (year / 400)); //формула Зеллера.
        int dayOfWeek = tempVar % 7;

        return dayOfWeek;
    }
}