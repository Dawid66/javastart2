package pl.sda.javastart2;

public class Calculator {

    public static int add(int x, int y) {
        return x + y;
    }

    public static int divide(int x, int y) {
        return x / y;
    }

    public static boolean checkIfEven(int x) {
        return x % 2 == 0;
    }

    public static boolean sleepIn(boolean weekend, boolean vacation) {
        if (!weekend || vacation) {
            return true;
        }
        return false;
    }
}
