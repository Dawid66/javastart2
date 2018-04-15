package pl.sda.javastart2.generics2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GenericUtils {

    public static List fromArrayToList(Object[] array) {
        return Arrays.asList(array);
    }

    public static <T extends Number> List<T> fromArrayToListWithGenerics(T[] array) {
        return Arrays.asList(array);
    }

    public static <T,G> List<G> formArrayToList(T[] array, Function<T,G> mysticFunction) {
        return Arrays.stream(array).map(mysticFunction).collect(Collectors.toList());
    }
    

}
