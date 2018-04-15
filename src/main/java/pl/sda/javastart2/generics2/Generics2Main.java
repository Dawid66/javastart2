package pl.sda.javastart2.generics2;

import pl.sda.javastart2.Person;
import pl.sda.javastart2.generics1.Apple;
import pl.sda.javastart2.generics1.Fruit;
import pl.sda.javastart2.generics1.Orange;

import java.util.ArrayList;
import java.util.List;

public class Generics2Main {
    public static void main(String[] args) {
        firstGenericExample();
        secondGenericExample();
        utilsExample();
    }

    private static void utilsExample() {
        Long[] longsArray = {1L, 2L};
        List list = GenericUtils.fromArrayToList(longsArray);
        Object o = list.get(0); //nienajlepiej

        List<Long> longs = GenericUtils.fromArrayToListWithGenerics(longsArray);

        Person[] people = new Person[]{new Person(123, "Ania")};
        List<Integer> integers = GenericUtils.formArrayToList(people, e -> e.getPesel());


    }

    private static void secondGenericExample() {
        GenericFruitBoxWithExtends<Apple> appleGenericFruitBoxWithExtends
                = new GenericFruitBoxWithExtends<>(new Apple());


        //        GenericFruitBoxWithExtends<T> tomek = new GenericFruitBoxWithExtends<>(new Person(123, "Tomek")); //nie da się


//        List<Object> objects = new ArrayList<>(); //przykład na możliwośc oszukania również siebie
//        objects.add(new Person(123, "Ania"));
//
//        GenericFruitBoxWithExtends<Fruit> tGenericFruitBoxWithExtends
//                = new GenericFruitBoxWithExtends<>((Fruit) objects.get(0));
    }

    private static void firstGenericExample() {
        GenericFruitBox<Orange> orangeGenericFruitBox =
                new GenericFruitBox<>(new Orange());

        orangeGenericFruitBox.getValue().introduceYourself();

        GenericFruitBox<Apple> appleGenericFruitBox =
                new GenericFruitBox<>(new Apple());

        appleGenericFruitBox.getValue().introduceYourself();

        GenericFruitBox<Person> personGenericFruitBox =
                new GenericFruitBox<>(new Person(123, "Ania"));

//        personGenericFruitBox.getValue().introduceYourself();
    }
}
