package pl.sda.javastart2.homework1;

import java.util.ArrayList;
import java.util.List;

public class Generics1 {
    public static void main(String[] args) {

// Napisz generyczną metodę która przyjmuje Listę elementów
// będących numerami i zwraca ich sumę
        List<String> listString = new ArrayList<>();
        List<Integer> listInteger = new ArrayList<>();
        listString.add("AC");
        listInteger.add(2);
//        sumGenericsNumbers(listString);
        sumGenericsNumbers(listInteger);
        sumGenericsNumbersWithStream(listInteger);


    }

    private static<T extends Number> Double sumGenericsNumbersWithStream(List<T> list) {
        return list.stream().mapToDouble(e->e.doubleValue()).sum();
    }

    public static <T extends Number> Long sumGenericsNumbers(List<T> list) {
        Long result =0L;
        for (T t : list) {
            result+= t.longValue();
        }
        return result;
    }
}
