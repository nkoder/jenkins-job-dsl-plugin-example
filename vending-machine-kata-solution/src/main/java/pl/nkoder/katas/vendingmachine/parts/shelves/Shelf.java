package pl.nkoder.katas.vendingmachine.parts.shelves;

import pl.nkoder.katas.vendingmachine.parts.money.Cost;
import pl.nkoder.katas.vendingmachine.products.Product;

class Shelf {

    public final Product product;
    public final Cost price;

    public Shelf(Product product, Cost price) {
        this.product = product;
        this.price = price;
    }
}
