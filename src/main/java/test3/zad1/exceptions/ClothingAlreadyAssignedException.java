package test3.zad1.exceptions;

import test3.zad1.models.Clothing;

public class ClothingAlreadyAssignedException extends RuntimeException {
    public ClothingAlreadyAssignedException(Clothing clothing) {
        super("This clothing is already in another wardrobe!");
    }
}
