package pl.sda.javastart2.concurrency;

public class Bank {

    private static int balance = 1000;

    private static int operations;

    public static void withdraw(int howMuch) {
        balance = balance - howMuch;
        System.out.println(Thread.currentThread().getName()+
        " Stan konta po wypłacie klienta : "+balance);
    }

    public static void giveBack(int howMuch){
        balance = balance + howMuch;
        System.out.println(Thread.currentThread().getName()+
                " Stan konta po wpłacie: "+balance);
        operations++;
    }

}
