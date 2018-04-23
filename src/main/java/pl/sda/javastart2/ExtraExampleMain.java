package pl.sda.javastart2;

public class ExtraExampleMain {
    public static void main(String[] args) {
        ExtraExample ania = ExtraExample.builder().age(2).name("Ania").build();
        System.out.println(ania);
    }
}
