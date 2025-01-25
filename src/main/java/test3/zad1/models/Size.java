package test3.zad1.models;

public enum Size {
    XS(34),
    S(36),
    M(38),
    L(40),
    XL(42);

    private final int numericSize;

    Size(int numericSize) {
        this.numericSize = numericSize;
    }

    public int getNumericSize() {
        return numericSize;
    }
}
