package task2232;

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

    public static int getYear() {
        return getIntValue("Year", 2001, 3000);
    }

    public static int getMonth() {
        return getIntValue("Month", 1, 12);
    }

    public static int getDay() {
        return getIntValue("Day", 1, 31);
    }

    public static int getIntValue(String m, int lowerLimit, int upperLimit) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Input " + m + ":");
            int tempVar = scanner.nextInt();
            if (isValueCorrect(tempVar, lowerLimit, upperLimit) == false) {
                System.out.println(lowerLimit + "<= Input value <=" + upperLimit);
            } else
                return tempVar;
        }
    }

    public static boolean isValueCorrect(int value, int lowerLimit, int upperLimit) {
        if (value < lowerLimit || value > upperLimit)
            return false;
        return true;
    }

    public static void showDayStatus(int year, int month, int day, boolean dayWeekend) {
        System.out.print(year + "/" + month + "/" + day + " -");
        if (dayWeekend == true) {
            System.out.print(" Weekend");
        } else
            System.out.print(" Work day");
    }

    public static boolean isDayWeekend(int dayOfWeek) {
        if (dayOfWeek == 0 || dayOfWeek == 6)
            return true;
        else
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
