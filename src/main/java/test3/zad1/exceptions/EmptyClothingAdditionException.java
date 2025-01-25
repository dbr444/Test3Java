package test3.zad1.exceptions;

public class EmptyClothingAdditionException extends RuntimeException {
    public EmptyClothingAdditionException() {
        super("Cannot add non chosen clothing to the wardrobe!");
    }
}
