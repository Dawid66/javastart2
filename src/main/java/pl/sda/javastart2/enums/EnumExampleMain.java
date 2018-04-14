package pl.sda.javastart2.enums;

import pl.sda.javastart2.Car;

import java.util.Arrays;

public class EnumExampleMain {
    public static void main(String[] args) {

        Car blackCar = new Car(ColourEnum.BLACK);
        Car whiteCar = new Car(ColourEnum.WHITE);
        Car anotherBlackCar = new Car(ColourEnum.BLACK);


        Car newCar = null;
        for (ColourEnum colourEnum : ColourEnum.values()) {
            if (colourEnum.getNumberValue() == 0) {
                newCar = new Car(colourEnum);
                break;
            }
        }
        System.out.println("new car: "+newCar);


        System.out.println(blackCar.equals(anotherBlackCar));

        ColourEnum[] values = ColourEnum.values();
        System.out.println(Arrays.toString(values));

    }
}
