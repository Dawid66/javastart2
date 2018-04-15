package pl.sda.javastart2.collections;

import pl.sda.javastart2.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExample {

    public static void main(String[] args) {
        basicMapOperations();
    }

    private static void basicMapOperations() {
        Person ania = new Person(123, "Ania");
        Person ola = new Person(234, "Ola");
        Person tomek1 = new Person(345, "Tomek");
        Person tomek2 = new Person(456, "Tomek");

        Map<Integer, Person> peopleByPesel = new HashMap<>();

        peopleByPesel.put(ania.getPesel(), ania);
        peopleByPesel.put(ola.getPesel(), ola);
        peopleByPesel.put(tomek1.getPesel(), tomek1);
        peopleByPesel.put(tomek2.getPesel(), tomek2);

        System.out.println(peopleByPesel);

        Map<String, Person> peopleByName = new HashMap<>();
        peopleByName.put(ania.getName(), ania);
        peopleByName.put(ola.getName(), ola);
        peopleByName.put(tomek1.getName(), tomek1);
        peopleByName.put(tomek2.getName(), tomek2);

        System.out.println(peopleByName); //tylko 3 wartośći

        properWayOfAddingPeople(ania);
        properWayOfAddingPeople(ania);
        properWayOfAddingPeople(ola);
        properWayOfAddingPeople(tomek1);
        properWayOfAddingPeople(tomek2);
    }

    private static void properWayOfAddingPeople(Person person) {
        Map<String, List<Person>> map = new HashMap<>();
        if (map.containsKey(person.getName())) {
            String name = person.getName();
            List<Person> people = map.get(name);
            people.add(person);
        } else {
            List<Person> people = new ArrayList<>();
            people.add(person);
            map.put(person.getName(), people);
        }

    }
}
