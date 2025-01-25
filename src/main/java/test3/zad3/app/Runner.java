package test3.zad3.app;

import test3.zad3.exceptions.EmptyArgumentListException;
import test3.zad3.models.MinMax;
import test3.zad3.models.Person;
import test3.zad3.services.MinMaxService;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        try {
            List<Integer> numbers = Arrays.asList(10, 5, 20, 8, 15);
            MinMax<Integer> minMaxNumbers = MinMaxService.getMinAndMax(numbers);
            System.out.println("Numbers: " + minMaxNumbers);

            List<String> words = Arrays.asList("apple", "banana", "zebra", "kiwi", "grape");
            MinMax<String> minMaxWords = MinMaxService.getMinAndMax(words);
            System.out.println("Words: " + minMaxWords);

            List<Person> people = Arrays.asList(
                    new Person("John", "Wick", 40),
                    new Person("Johnny", "Depp", 25),
                    new Person("Marilyn", "Manson", 56),
                    new Person("Katy", "Perry", 38)
            );

            MinMax<Person> peopleMinMax = MinMaxService.getMinAndMax(people);
            System.out.println("People: " + peopleMinMax);

            //wyjatek z pusta lista
//            List<Integer> emptyList = List.of();
//            MinMax<Integer> minMaxEmpty = MinMaxService.getMinAndMax(emptyList);
        } catch (EmptyArgumentListException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
