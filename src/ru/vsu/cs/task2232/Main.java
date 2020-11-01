package task2232;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int year;
        int month;
        int day;
        int dayOfWeek;
        boolean dayWeekend;

        year = getYear();
        month = getMonth();
        day = getDay();
        dayOfWeek = getDayOfWeek(year, month, day);
        dayWeekend = isDayWeekend(dayOfWeek);
        showDayStatus(year, month, day, dayWeekend);
    }

    public static int getDay() {
        int day;
        Scanner s1 = new Scanner(System.in);

        while (true) {
            System.out.print("Input day:");
            day = s1.nextInt();
            if (day < 1 || day > 31) {
                System.out.println("Input error! 0 < day < 32");
                continue;
            } else
                break;
        }
        return day;
    }

    public static int getMonth() {
        int month;
        Scanner s1 = new Scanner(System.in);

        while (true) {
            System.out.print("Input month:");
            month = s1.nextInt();
            if (month < 1 || month > 12) {
                System.out.println("Input error! 0 < month < 13");
                continue;
            } else
                break;
        }
        return month;
    }

    public static int getYear() {
        int year;
        Scanner s1 = new Scanner(System.in);

        while (true) {
            System.out.print("Input year:");
            year = s1.nextInt();
            if (year < 2001 || year > 3000) {
                System.out.println("Input error! 2000 < year < 3001");
                continue;
            } else
                break;
        }
        return year;

    }

    public static void showDayStatus(int year, int month, int day, boolean dayWeekend) {
        System.out.print(year);
        System.out.print('/');
        System.out.print(month);
        System.out.print('/');
        System.out.print(day);
        System.out.print(' ');
        System.out.print('-');
        if (dayWeekend == true) {
            System.out.print(" Weekend");
            return;
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
        int dayOfWeek;
        int tempVar;

        if (month == 1 || month == 2) {
            year = year - 1;
            month = month + 10;
        } else
            month = month - 2;
        tempVar = (day + ((31 * month) / 12) + year + (year / 4) - (year / 100) + (year / 400)); //формула Зеллера.
        dayOfWeek = tempVar % 7;
        return dayOfWeek;
    }
}
