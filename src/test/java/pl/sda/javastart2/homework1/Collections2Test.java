package pl.sda.javastart2.homework1;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class Collections2Test {


    @Test
    void name() {
        Map<Double, Integer> doubleIntegerMap = Collections2.salaryStats();

        assert doubleIntegerMap.get(1200.0) == 2;

    }
}