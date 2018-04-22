package pl.sda.javastart2.homework1;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;

public class Collections2 {
    public static void main(String[] args) {
        giveMeNameAndSurnameList();
        giveMeNameAndSurnameListWithStream();
        salaryStats();
        salaryStatsWithStream();
        nameSalaryStats();
    }

    //NApisz metodę, która zwróci mapę map <imię,<zarobki,liczba_osób_z_takimi_zarobkami>>
    protected static Map<String, Map<Double, Integer>> nameSalaryStats() {
        List<Customer> customers = giveMeCustomers();
//        Map<String, Map<Double, Integer>> resultMap = Maps.newHashMap();
        customers.stream().forEach(e->e.setName(e.getName().trim()));
        Map<String, Map<Double, Integer>> resultMap = new HashMap<>();
        for (Customer customer : customers) {
            if (resultMap.containsKey(customer.getName())) { //sprawdzamy czy imię istnieje
                Map<Double, Integer> innerMap = resultMap.get(customer.getName());
                if (innerMap.containsKey(customer.getSalary())) {
                    Integer counter = innerMap.get(customer.getSalary());
                    innerMap.replace(customer.getSalary(), counter + 1);
                } else {
                    innerMap.put(customer.getSalary(), 1);
                }
            } else { //sytuacja kiedy imię nie istnieje w mapie
                Map<Double, Integer> newMap = Maps.newHashMap();
                newMap.put(customer.getSalary(), 1);
                resultMap.put(customer.getName(), newMap);
            }
        }
        return resultMap;
    }

    private static Map<Double, List<Customer>> salaryWithPersonListWithStream() {
        return giveMeCustomers()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getSalary()));
    }

    private static Map<Double, List<Customer>> salaryWithPersonList() {
        List<Customer> customers = giveMeCustomers();
        Map<Double, List<Customer>> map = new HashMap<>();
        for (Customer customer : customers) {
            if (map.containsKey(customer.getSalary())) {
                List<Customer> customersInsideMap
                        = map.get(customer.getSalary());
                customersInsideMap.add(customer);
            } else {
                /*
                List<Customer> newList = new ArrayList<>();
                newList.add(customer);
                */
                map.put(customer.getSalary(), Lists.newArrayList(customer));
            }
        }
        return map;
    }

    private static Map<Double, Long> salaryStatsWithStream() {
        return giveMeCustomers().stream()
                .collect(Collectors.groupingBy(
                        e -> e.getSalary(),
                        Collectors.counting()
                        )
                );
    }

    //Napisz metodę, która zwróci statystykę ile jest osób z danymi
    //zarobkami <zarobki,liczba_osób> Map<Double,Integer>
    protected static Map<Double, Integer> salaryStats() {
        List<Customer> customers = giveMeCustomers();
        Map<Double, Integer> map = new HashMap<>();
        for (Customer customer : customers) {
            if (map.containsKey(customer.getSalary())) {
                Integer licznik = map.get(customer.getSalary());
                map.replace(customer.getSalary(), licznik + 1);
            } else {
                map.put(customer.getSalary(), 1);
            }
        }
        return map;
    }

    private static List<String> giveMeNameAndSurnameListWithStream() {
        return giveMeCustomers().stream()
                .map(e -> e.getName().trim() + " " + e.getSurname().trim())
                .collect(Collectors.toList());
    }

    private static List<String> giveMeNameAndSurnameList() {
        List<Customer> customers = giveMeCustomers();
//        List<String> result = new ArrayList<>();
        List<String> result = Lists.newArrayList();
        for (Customer customer : customers) {
            String nameWithSurname = customer.getName().trim()
                    + " " + customer.getSurname().trim();
            result.add(nameWithSurname);
        }
        return result;
    }

    //    Napiszcie klasę Customer, która będzie reprezentować dane
// z tablicy + będzie dobierać kolejne id dla kolejnych tworzonych
// obiektów -> Anna powinna otrzymać id = 1 a Marek id = 3
    public static List<Customer> giveMeCustomers() {
        Customer[] people = new Customer[]{
                new Customer("Anna", "Nowak   ", 33, "1200"),
                new Customer("Beata", "Kowalska", 22, "1200"),
                new Customer("Marek", " Nowak", 25, "1250"),
                new Customer("Adam", "Twardowski", 33, "1100"),
                new Customer("Monika  ", "Kos", 25, "2500"),
                new Customer("Adam ", "Rudy", 45, "3333"),
                new Customer("Marek", "Rudy", 15, 2210),
                new Customer("Adam", "Madej", 15, 3333)
        };
        return Arrays.asList(people);
    }
    //    Napisz metodę, która przyjmie tablicę people
// i zwróci listę Stringów <imię nazwisko>
// (elementem listy będzie np "Anna Nowak")


}
