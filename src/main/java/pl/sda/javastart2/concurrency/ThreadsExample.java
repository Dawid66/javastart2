package pl.sda.javastart2.concurrency;

import com.google.common.collect.Lists;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadsExample {

    public static void main(String[] args) {
//        runnableBasics();
//        bank();
//        bankWithThreads();
        bankWithExecutors();
    }

    private static void bankWithExecutors() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        List<BankClientAction> actions = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            actions.add(new BankClientAction());
        }
        for (BankClientAction action : actions) {
            executorService.submit(action);
        }

    }

    private static void bankWithThreads() {
        List<BankClientAction> actions = Lists.newArrayList();
        for (int i = 0; i < 1000; i++) {
            actions.add(new BankClientAction());
        }

        List<Thread> threadsList = Lists.newArrayList();
        for (BankClientAction action : actions) {
            threadsList.add(new Thread(action));
        }

        Instant start = Instant.now();
        for (Thread thread : threadsList) {
            thread.start();
        }
        for (Thread thread : threadsList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ilość operacji " + Bank.operations);
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