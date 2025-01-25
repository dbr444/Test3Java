package test3.zad1.exceptions;

import test3.zad1.models.Clothing;

public class DuplicateClothingException extends RuntimeException {
    public DuplicateClothingException(Clothing clothing) {
        super("This item is already in the wardrobe: " + clothing);
    }
}

