package pl.sda.javastart2.generics2;

public class GenericFruitBox<T> {

    private T value;

    public GenericFruitBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
