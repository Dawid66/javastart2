package pl.sda.javastart2.homework1;

import java.io.Serializable;

public class Customer implements Serializable{

    private static int counter = 1;

    private int id;
    private String name;
    private String surname;
    private int age;
    private double salary;

    public Customer(String name, String surname, int age, String salary) {
        this(name, surname, age, Integer.parseInt(salary));
//        this.id = counter++;
//        this.name = name;
//        this.surname = surname;
//        this.age = age;
//        this.salary = Integer.parseInt(salary); // "3000" zamieni na liczbę
    }

    public Customer(String name, String surname, int age, double salary) {

        this.id = counter++;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
