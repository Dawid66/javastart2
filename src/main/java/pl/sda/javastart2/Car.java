package pl.sda.javastart2;

import pl.sda.javastart2.enums.ColourEnum;

public class Car {
//    private String colour;

    private ColourEnum colour;

    public Car(ColourEnum colour) {
        this.colour = colour;
    }

    public ColourEnum getColour() {
        return colour;
    }

    @Override
    public boolean equals(Object obj) {
        return colour.equals(((Car) obj).getColour());
    }

    @Override
    public String toString() {
        return "Car{" +
                "colour=" + colour +
                '}';
    }
}
