package test3.zad1.models;

public abstract class Clothing implements Comparable<Clothing> {
    private static SortingCriterion sortingCriterion = SortingCriterion.SIZE;
    private final String name;
    private final Size size;
    private final double price;
    private Wardrobe wardrobe;

    public Clothing(String name, Size size, double price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    void assignToWardrobe(Wardrobe wardrobe) {
        this.wardrobe = wardrobe;
    }

    public static void setSortingCriterion(SortingCriterion newSortingCriterion) {
        sortingCriterion = newSortingCriterion;
    }


    @Override
    public int compareTo(Clothing o) {
        int result = 0;

        switch (sortingCriterion) {
            case NAME -> {
                result = name.compareTo(o.name);
                if (result == 0) {
                    result = Integer.compare(size.getNumericSize(), o.size.getNumericSize());
                }
                if (result == 0) {
                    result = Double.compare(price, o.price);
                }
            }
            case SIZE -> {
                result = Integer.compare(size.getNumericSize(), o.size.getNumericSize());
                if (result == 0) {
                    result = Double.compare(price, o.price);
                }
                if (result == 0) {
                    result = name.compareTo(o.name);
                }
            }
            case PRICE -> {
                result = Double.compare(price, o.price);
                if (result == 0) {
                    result = Integer.compare(size.getNumericSize(), o.size.getNumericSize());
                }
                if (result == 0) {
                    result = name.compareTo(o.name);
                }
            }
        }

        return result;
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
