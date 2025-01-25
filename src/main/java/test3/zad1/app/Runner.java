package test3.zad1.app;
import test3.zad1.exceptions.DuplicateClothingException;
import test3.zad1.exceptions.EmptyClothingAdditionException;
import test3.zad1.models.*;
import java.util.Collections;

public class Runner {
    public static void main(String[] args) {
        Wardrobe wardrobe = new Wardrobe();

        Shirt shirt = new Shirt("Shirt", Size.L, 120.4);
        Trousers jeans = new Trousers("Jeans", Size.M, 200.0);
        Trousers chinos = new Trousers("Chinos", Size.S, 180.0);
        Panties panties = new Panties("Panties", Size.XL, 90.5);

        //Wybrałem utworzenie konkrentych ubrań, zamiast totalnie randomowych będących jedną, ogólniejszą klasą.
        //Mam nadzieję, że jest git:)

        //dales tez w zadaniu m.in. takie cos:
        //ma dzialac taki kod:
        //szafa.dodajUbranie(...); - i tutaj nie wiem czy ma sie po prostu nic nie dodac czy to obsluzyc, wiec
        //uznalem, ze po prostu rzuce wyjatek

        try {
            wardrobe.addClothing(shirt, jeans, chinos);
            wardrobe.addClothing(panties);
//            wardrobe.addClothing(panties); - wyjatek z duplikatem
//            wardrobe.addClothing(); - wyjatek z brakiem parametru
        } catch (EmptyClothingAdditionException | DuplicateClothingException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("************************************");


        System.out.println("Clothes in the wardrobe:");
        for (Clothing c : wardrobe) {
            System.out.println(c);
        }

        System.out.println("************************************");
        Clothing largest = Collections.max(wardrobe.getClothes());
        System.out.println("Largest clothing: " + largest);

        //zmiana kryterium
        Clothing.setSortingCriterion(SortingCriterion.PRICE);
        System.out.println("************************************");
        Clothing mostExpensive = Collections.max(wardrobe.getClothes());
        System.out.println("Most expensive clothing: " + mostExpensive);

        System.out.println("************************************");
        Clothing.setSortingCriterion(SortingCriterion.NAME);
        Clothing firstAlphabetically = Collections.min(wardrobe.getClothes());
        System.out.println("First alphabetically: " + firstAlphabetically);
    }
}
