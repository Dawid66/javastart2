package pl.sda.javastart2;

public class Person implements Comparable<Person>{
    private Integer pesel;
    private String name;

    public Person(Integer pesel, String name) {
        this.pesel = pesel;
        this.name = name;
    }


    public Integer getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return "Person{" +
                "pesel=" + pesel +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return pesel.compareTo(o.getPesel());
    }

    public String getName() {
        return name;
    }
}
