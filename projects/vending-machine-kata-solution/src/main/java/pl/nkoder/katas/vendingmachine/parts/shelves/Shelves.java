package pl.nkoder.katas.vendingmachine.parts.shelves;

import pl.nkoder.katas.vendingmachine.parts.money.Cost;
import pl.nkoder.katas.vendingmachine.products.Product;

import java.util.HashMap;
import java.util.Map;

public class Shelves {

    private final Map<Integer, Shelf> shelvesByNumbers = new HashMap<>();

    public Shelves putProduct(Product product, int shelfNumber, Cost cost) {
        shelvesByNumbers.put(shelfNumber, new Shelf(product, cost));
        return this;
    }

    public Cost priceOfProductAtShelf(int shelfNumber) {
        return shelvesByNumbers.get(shelfNumber).price;
    }

    public Product productAtShelf(int shelfNumber) {
        return shelvesByNumbers.get(shelfNumber).product;
    }
}
