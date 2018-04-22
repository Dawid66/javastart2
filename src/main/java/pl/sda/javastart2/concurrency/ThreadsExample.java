package pl.sda.javastart2.concurrency;

import com.google.common.collect.Lists;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ThreadsExample {

    public static void main(String[] args) {
        runnableBasics();
        bank();
        bankWithThreads();
    }

    private static void bankWithThreads() {
        List<BankClientAction> actions = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            actions.add(new BankClientAction());
        }

        List<Thread> threads = Lists.newArrayList();

        Instant start = Instant.now();
        for (BankClientAction action : actions) {
            action.run();
        }
        System.out.println(
                Duration.between(start, Instant.now()).getNano()
        );
    }

    private static void bank() {
        List<BankClientAction> actions = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            actions.add(new BankClientAction());
        }
        Instant start = Instant.now();
        for (BankClientAction action : actions) {
            action.run();
        }
        System.out.println(
                Duration.between(start, Instant.now()).getNano()
        );

    }

    private static void runnableBasics() {
        Runnable runnable = new Runnable() { //zagnieżdżona klasa anonimowa
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()
                        + " Anonimowa klasa zagnieżdżona");
            }
        };

        Runnable lambdaRunnable = () -> System.out.println(
                Thread.currentThread().getName() +
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
        lambdaRunnable.run();

    }
}