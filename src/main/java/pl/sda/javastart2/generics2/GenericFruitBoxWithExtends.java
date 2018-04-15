package pl.sda.javastart2.generics2;

import pl.sda.javastart2.generics1.Fruit;

public class GenericFruitBoxWithExtends<T extends Fruit> {

    private T value;

    public GenericFruitBoxWithExtends(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
