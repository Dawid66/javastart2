package pl.sda.javastart2.exceptions;

import com.google.common.collect.ObjectArrays;

public class SimplePositiveNumbersBox<T extends Number> {
    private T[] numbers; //niezmienna wielkość

    public SimplePositiveNumbersBox(T[] numbers) {
        this.numbers = numbers;
    }

    //konstruktor z gwiazdką *
    public SimplePositiveNumbersBox(Class<T> tClass, int size) {
        this.numbers = ObjectArrays.newArray(tClass, size);
    }

    public void setValue(int index, T value) throws OutOfBoxException {
        if (value.doubleValue() < 0) {
            throw new NegativeNumberException("Ujemna liczba!");
        }
        if (index < 0 || index >= numbers.length) {
            throw new OutOfBoxException("Nie ma takiego indeksu");
        }
        numbers[index] = value;
    }


    public T getValue(int index) throws OutOfBoxException {
        if (index < 0 || index >= numbers.length) {
            throw new OutOfBoxException("Nie ma takiego indeksu");
        }
        return numbers[index];
    }


}
