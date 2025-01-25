package test3.zad3.services;

import test3.zad3.exceptions.EmptyArgumentListException;
import test3.zad3.models.MinMax;

import java.util.Collections;
import java.util.List;

public class MinMaxService {
    public static <T extends Comparable<T>> MinMax<T> getMinAndMax(List<T> elements) {
        if (elements == null || elements.isEmpty()) {
            throw new EmptyArgumentListException();
        }

        T min = Collections.min(elements);
        T max = Collections.max(elements);

        return new MinMax<>(min, max);
    }
}

