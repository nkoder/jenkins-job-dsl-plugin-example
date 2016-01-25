package pl.nkoder.katas.vendingmachine;

import org.junit.Test;
import pl.nkoder.katas.vendingmachine.parts.shelves.Shelves;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.nkoder.katas.vendingmachine.parts.money.Cost.costOf;
import static pl.nkoder.katas.vendingmachine.products.ProductsForTests.COLA;
import static pl.nkoder.katas.vendingmachine.products.ProductsForTests.MARS;

public class ShelvesShould {

    @Test
    public void know_prices_of_products() {
        Shelves shelves = new Shelves();
        shelves.putProduct(COLA, 1, costOf("0.1"));
        shelves.putProduct(MARS, 2, costOf("999.9"));

        assertThat(shelves.priceOfProductAtShelf(2).asText()).isEqualTo("999.9");
        assertThat(shelves.priceOfProductAtShelf(1).asText()).isEqualTo("0.1");
    }
}
