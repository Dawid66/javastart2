package pl.sda.javastart2.collections;

import java.util.*;

public class ListVsSet {

    public static void main(String[] args) {

        removeAllCompare();
    }

    private static void removeAllCompare() {

        //setRemoveList();
        listRemoveSet();
        checkIfCollectionContains();
    }

    private static void checkIfCollectionContains() {
        Set<Book> booksSet = new HashSet<>();
        int howManyBooks = 10_500_000;
        for (int i = 0; i < howManyBooks; i++) {
            booksSet.add(new Book(i));
        }
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < howManyBooks; i++) {
            bookList.add(new Book(i));
        }
        long start = System.currentTimeMillis();
        bookList.contains(new Book(howManyBooks));
        long finish = System.currentTimeMillis();
        long start2 = System.currentTimeMillis();
        booksSet.contains(new Book(howManyBooks));
        long finish2 = System.currentTimeMillis();
        System.out.println("List: " + (finish - start) + " Set: "
                + (finish2 - start2));
    }

    private static void listRemoveSet() {
        Set<Book> booksSet = new HashSet<>();
        int howManyBooks = 500_000;
        for (int i = 0; i < howManyBooks; i++) {
            booksSet.add(new Book(i));
        }
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < howManyBooks + 1; i++) {
            bookList.add(new Book(i));
        }
        long start = System.currentTimeMillis();
        bookList.removeAll(booksSet);
        long finish = System.currentTimeMillis();
        System.out.println("bookList.removeAll(bookSet): "
                +(finish-start)+" ms");

    }

    private static void setRemoveList() {
        Set<Book> booksSet = new HashSet<>();
        int howManyBooks = 500_000;
        for (int i = 0; i < howManyBooks; i++) {
            booksSet.add(new Book(i));
        }
        List<Book> bookList = new ArrayList<>();
        for (int i = 0; i < howManyBooks + 1; i++) {
            bookList.add(new Book(i));
        }
        long start = System.currentTimeMillis();
        booksSet.removeAll(bookList);
        long finish = System.currentTimeMillis();
        System.out.println("booksSet.removeAll(bookList): "
                +(finish-start)+" ms");
    }


}
