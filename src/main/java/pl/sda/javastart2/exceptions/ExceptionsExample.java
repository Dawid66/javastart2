package pl.sda.javastart2.exceptions;

public class ExceptionsExample {
    public static void main(String[] args) {
//        simpleExceptionWhenDividing();

        Integer[] integers = {1, 2, 3};

        SimplePositiveNumbersBox<Integer> positiveNumbersBox =
                new SimplePositiveNumbersBox<>(integers);
        try {
            Integer value = positiveNumbersBox.getValue(5);
        }catch (OutOfBoxException exc){
            System.out.println(exc.getMessage());
        }

        try {
            positiveNumbersBox.setValue(6, -2);
        } catch (OutOfBoxException | RuntimeException x) {
            System.out.println(x.getMessage());
        }
        System.out.println("SZCZĘSliwie Koniec");
    }

    private static void simpleExceptionWhenDividing() {
        double result1 = divide(2, 4);
        double result2 = divideWithStableResult(2, 4);
        divideManyTimes(2, 3, 1, 3, 5);
    }


    private static double divide(int x, int y) {
        return x / y;
    }

    private static double divideWithStableResult(int x, int y) {
        try {
            System.out.println("Inside try");
            return x / y;
        } finally {
            System.out.println("Inside Finally block");
            return -1; //nie umieszczaj return w finally
        }
    }

    //varargs
    private static double divideManyTimes(int x, int... dividers) {
        double result = x;
        for (int divider : dividers) {
            result = x / divider;
        }
        return result;
    }
}

