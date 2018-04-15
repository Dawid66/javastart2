package pl.sda.javastart2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddCorrectly() {
        int sum = Calculator.add(1, 2);
        assert sum == 3;
    }

    @Test
    void shouldAddCorrectlyNegativeNumbers() {
        int sum = Calculator.add(1, -2);
        assert sum == -1;
    }

    @Test
    void shouldAddCorrectlyWithZero() {
        int sum = Calculator.add(0, -2);
        assert sum == -2;
    }

    @Test
    void testSleepInWhenItIsNotWeekendAndWeAreNotOnVacation() {
        boolean b1 = Calculator.sleepIn(false, false);
        assert b1;
    }

    @Test
    void testSleepInWhenItIsWeekendAndWeAreNotOnVacation() {
        boolean b2 = Calculator.sleepIn(true, false);
        assert !b2;
    }

    @Test
    void testSleepInWhenItIsNotWeekendAndWeAreOnVacation() {
        boolean b3 = Calculator.sleepIn(false, true);
        assert b3;
    }
}