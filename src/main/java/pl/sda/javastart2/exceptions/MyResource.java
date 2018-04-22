package pl.sda.javastart2.exceptions;

public class MyResource implements AutoCloseable{

    public void doSomeWork(String work) {
        System.out.println("Doing "+work);
        throw new RuntimeException("Exception during work");
    }

    public void close(){
        System.out.println("Closing resource");
        throw new RuntimeException("Exception during closing");
    }
}
