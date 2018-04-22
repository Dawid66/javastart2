package pl.sda.javastart2.exceptions;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class TryWithResourcesExample {
    private static final Logger LOGGER =
            Logger.getLogger(TryWithResourcesExample.class.getSimpleName());

    static {
        try {
            LOGGER.addHandler(new FileHandler("C:\\projects\\logs.txt"));
        } catch (IOException e) {
            System.out.println("Przykro mi");
        }
    }

    public static void main(String[] args) {
//        LOGGER.addHandler();
        tryWithResourcesOldWay();
        tryWithResourcesNewWay();
    }

    private static void tryWithResourcesNewWay() {
        try (MyResource myResource = new MyResource()) {
            myResource.doSomeWork("Odczyt danych po nowemu");
        }catch (Exception e){
            LOGGER.severe("Odczyt danych po nowemu exception");
        }
    }

    private static void tryWithResourcesOldWay() {
        MyResource myResource = new MyResource();
        try {
            myResource.doSomeWork("Odczyt danych");
        } catch (Exception e) {
            System.out.println("Exception podczas wykonania zadania");
        } finally {
            try {
                myResource.close();
            } catch (Exception e) {
                System.out.println("Exception podczas zamykania połączenia");
            }
        }
    }
}
