package test3.zad3.exceptions;
public class EmptyArgumentListException extends RuntimeException {
    public EmptyArgumentListException() {
        super("Cannot do calculations - the list is empty!");
    }
}

