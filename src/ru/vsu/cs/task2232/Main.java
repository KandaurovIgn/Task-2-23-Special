package task2232;

import java.util.Scanner;

public class Main {

    enum Data {
        DAY, MONTH, YEAR
    }
    ;

    public static void main(String[] args) {
        int year = getData(Data.YEAR);
        int month = getData(Data.MONTH);
        int day = getData(Data.DAY);
        int dayOfWeek = getDayOfWeek(year, month, day);
        boolean dayWeekend = isDayWeekend(dayOfWeek);

        showDayStatus(year, month, day, dayWeekend);
    }

    public static int getData(Data d) {

        if (d == Data.DAY) {
            System.out.print("Input Day:");
            return getIntValue(1, 31);
        }
        if (d == Data.MONTH) {
            System.out.print("Input Month:");
            return getIntValue(1, 12);
        }
        if (d == Data.YEAR) {
            System.out.print("Input Year:");
            return getIntValue(2001, 3000);
        }

        return 0;
    }

    public static int getIntValue(int lowerLimit, int upperLimit) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int tempVar = scanner.nextInt();
            if (isDataCorrect(tempVar, lowerLimit, upperLimit) == false) {
                System.out.println(lowerLimit + "<= Input value <=" + upperLimit);
                System.out.print("Input:");
            } else
                return tempVar;
        }
    }

    public static boolean isDataCorrect(int data, int lowerLimit, int upperLimit) {
        if (data < lowerLimit || data > upperLimit)
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
