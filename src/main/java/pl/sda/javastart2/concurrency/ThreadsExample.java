package pl.sda.javastart2.concurrency;

public class ThreadsExample {

    public static void main(String[] args) {
        runnableBasics();
    }

    private static void runnableBasics() {
        Runnable runnable = new Runnable() { //zagnieżdżona klasa anonimowa
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()
                        +" Anonimowa klasa zagnieżdżona");
            }
        };

        Runnable lambdaRunnable = () -> System.out.println(
                Thread.currentThread().getName()+
                " Lambda");

        Runnable ourRunnable = new OurRunnable();

        //odpalenie zadań w osobnych wątkach
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(lambdaRunnable);
        Thread thread3 = new Thread(ourRunnable);
        thread1.start();
        thread2.start();
        thread3.start();

        //odpalenie bez osobnych wątków
        ourRunnable.run();

    }
}