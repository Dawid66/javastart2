package pl.sda.javastart2.collections;

import pl.sda.javastart2.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayListExample {

    public static void main(String[] args) {
//        basicListOperations();
        doesContainAll();
        sortList();
    }

    private static void sortList() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        list.add(2L);
        list.add(3L);
        list.add(4L);
        list.add(3L);

        list.sort(Comparator.naturalOrder());

        Collections.sort(list);

        System.out.println(list);

        List<Person> people = new ArrayList<>();
        people.add(new Person(123, "Ania"));
        people.add(new Person(122, "Tomek"));
        people.add(new Person(15, "Adam"));
        people.add(new Person(12, "Ola"));

        Collections.sort(people);
        System.out.println(people);

        System.out.println(people.stream()
                .sorted((a, b) -> a.getPesel().compareTo(b.getPesel()))
                .map(e -> e.getName())
                .collect(Collectors.joining(", ")));

        List<Integer> pesels =
                people.stream()
                        .filter(person->!person.getName().equals("Adam"))
                        .sorted((a, b) -> a.getName().compareTo(b.getName()))
                        .map(e -> e.getPesel())
                        .collect(Collectors.toList());
        System.out.println(pesels);
    }

    private static void doesContainAll() {
        List<String> firstList = new ArrayList<>();
        firstList.add("1");
        firstList.add("2");
        firstList.add("3");

        List<String> secondList = new ArrayList<>();
        secondList.add("1");
        secondList.add("2");

        System.out.println(firstList.containsAll(secondList));

        secondList.add("3");

        System.out.println(firstList.containsAll(secondList));

        secondList.add("4");

        System.out.println(firstList.containsAll(secondList));
        System.out.println(secondList.containsAll(firstList));

        System.out.println("Pierwsza lista: " + firstList);
        System.out.println("Druga lista: " + secondList);

        Collections.swap(firstList, 1, 2);

        System.out.println("Pierwsza lista: " + firstList);
        System.out.println("Druga lista: " + secondList);

    }

    private static void basicListOperations() {
        //niefajnie  ArrayList<String> firstList = new ArrayList<>();
        List<String> firstList = new ArrayList<>();
        System.out.println("Is list empty? " + firstList.isEmpty());
        System.out.println("List size: " + firstList.size());
        firstList.add("JAVA");
        firstList.add("C++");
        firstList.add("PERL");
        firstList.add("PYTHON");

        System.out.println(firstList);
        System.out.println(firstList.toString());

        System.out.println("Element at index 3: " + firstList.get(3));
        System.out.println("Does contain PERL?" + firstList.contains("PERL"));
        firstList.add(1, "JAVASCRIPT");
        System.out.println("After JAVASCRIPT added:" + firstList);
        System.out.println("Is list empty? " + firstList.isEmpty());
        System.out.println("List size: " + firstList.size());

        firstList.remove("JAVA");
        System.out.println("After \"JAVA\" remove: " + firstList);


        for (String value : firstList) {
            System.out.println(value);
        }
        firstList.stream().forEach(el -> System.out.println(el));

        for (String value : firstList) {
            boolean lastItem = firstList.indexOf(value) + 1 == firstList.size();
            System.out.print(value + (lastItem ? "" : ", "));
        }
        System.out.println();

        String collect = firstList.stream().collect(Collectors.joining(", "));
        System.out.println(collect);
    }

}
