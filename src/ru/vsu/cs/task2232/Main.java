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

    public static int getDay() {
        int day;
        boolean isDay;

        do {
            isDay = true;
            System.out.print("Input Day:");
            day = getIntData();
            if (day < 1 || day > 31) {
                System.out.println("Input ERROR! 0 < day < 32");
                isDay = false;
            }
        } while (!isDay);

        return day;
    }

    public static int getMonth() {
        int month;
        boolean isMonth;

        do {
            isMonth = true;
            System.out.print("Input Month:");
            month = getIntData();
            if (month < 1 || month > 12) {
                System.out.println("Input ERROR! 0 < Month < 13");
                isMonth = false;
            }
        } while (!isMonth);

        return month;
    }

    public static int getYear() {
        int year;
        boolean isYear;

        do {
            isYear = true;
            System.out.print("Input Year:");
            year = getIntData();
            if (year < 2001 || year > 3000) {
                System.out.println("Input ERROR! 2000 < Year < 3001");
                isYear = false;
            }
        } while (!isYear);

        return year;
    }

    public static int getIntData() {
        Scanner scanner = new Scanner(System.in);

        return scanner.nextInt();
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
