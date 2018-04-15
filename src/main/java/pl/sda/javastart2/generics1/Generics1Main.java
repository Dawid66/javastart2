package pl.sda.javastart2.generics1;

public class Generics1Main {

    public static void main(String[] args) {
        firstStepInGenerics();
        secondStepInGenerics();

    }

    private static void secondStepInGenerics() {
        FruitBox fruitBoxOfApples = new FruitBox(new Apple());
        FruitBox fruitBoxOfOranges = new FruitBox(new Orange());
        Fruit fruitApple = fruitBoxOfApples.getFruit();
        Fruit fruitOrange = fruitBoxOfOranges.getFruit();
    }

    private static void firstStepInGenerics() {
        OrangeBox orangeBox = new OrangeBox(new Orange());
        AppleBox appleBox = new AppleBox(new Apple());
    }
}
