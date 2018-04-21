package pl.sda.javastart2.homework1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class Generics1Test {
    @Test
    void shouldSummarizeListInt() {
        List<Number> integerArrayList = new ArrayList<>();
        integerArrayList.add(1L);
        integerArrayList.add(6);
        integerArrayList.add(8);


        Long sum = Generics1.sumGenericsNumbers(integerArrayList);
        assert sum == 15;

    }
}