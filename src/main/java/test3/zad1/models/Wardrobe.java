package test3.zad1.models;

import test3.zad1.exceptions.DuplicateClothingException;
import test3.zad1.exceptions.EmptyClothingAdditionException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Wardrobe implements Iterable<Clothing> {
    private final List<Clothing> clothes;

    public Wardrobe() {
        this.clothes = new ArrayList<>();
    }

    public void addClothing(Clothing... newClothes) {
        if (newClothes.length == 0) {
            throw new EmptyClothingAdditionException();
        }
        for (Clothing c : newClothes) {
            if (clothes.contains(c)) {
                throw new DuplicateClothingException(c);
            }
            c.assignToWardrobe(this);
            clothes.add(c);
        }
    }

    public List<Clothing> getClothes() {
        return new ArrayList<>(clothes);
    }

    @Override
    public Iterator<Clothing> iterator() {
        return clothes.iterator();
    }
}

