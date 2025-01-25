package test3.zad3.models;

public class Person implements Comparable<Person> {
    private final String firstName;
    private final String lastName;
    private final int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        int result = lastName.compareTo(o.lastName);
        if (result == 0) {
            result = firstName.compareTo(o.firstName);
        }
        if (result == 0) {
            result = Integer.compare(age, o.age);
        }
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}

