package pl.nkoder.katas.vendingmachine;

import org.assertj.core.api.AbstractAssert;
import pl.nkoder.katas.vendingmachine.parts.money.Coin;
import pl.nkoder.katas.vendingmachine.products.Product;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

import static com.google.common.collect.Lists.newArrayList;
import static java.lang.String.format;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

public class VendingMachineAssert extends AbstractAssert<VendingMachineAssert, VendingMachine> {

    public VendingMachineAssert(VendingMachine actual) {
        super(actual, VendingMachineAssert.class);
    }

    public VendingMachineAssert displaysMessage(String expectedMessage) {
        assertThat(actual.displayedMessage())
            .as("Displayed message")
            .isEqualTo(expectedMessage);
        return myself;
    }

    public VendingMachineAssert hasNoProductInTakeOutTray() {
        assertThat(actual.productsInTakeOutTray())
            .as("Products in take-out tray")
            .isEmpty();
        return myself;
    }

    public VendingMachineAssert hasInTakeAwayTray(Product... expectedProducts) {
        compare(
            actual.productsInTakeOutTray(),
            newArrayList(expectedProducts),
            () -> "Number of product types in take-out tray",
            product -> format("Number of products in take-out tray of type %s", product));
        return myself;
    }

    public VendingMachineAssert returnedNoCoins() {
        assertThat(actual.returnedCoins())
            .as("Returned coins")
            .isEmpty();
        return myself;
    }

    public VendingMachineAssert returnedCoins(Coin... expectedCoins) {
        compare(
            actual.returnedCoins(),
            newArrayList(expectedCoins),
            () -> "Number of returned coin types",
            coin -> format("Number of returned coins of type %s", coin));
        return myself;
    }

    private <T> void compare(Iterable<T> actualThings, Iterable<T> expectedThings,
                             Supplier<String> sizeAssertionDescription, Function<T, String> entryAssertDescription) {
        Map<T, Long> actualThingsAsMap = asMap(actualThings);
        Map<T, Long> expectedThingsAsMap = asMap(expectedThings);
        assertThat(actualThingsAsMap)
            .as(sizeAssertionDescription.get())
            .hasSameSizeAs(expectedThingsAsMap);
        expectedThingsAsMap.entrySet().forEach(expectedEntry -> {
            T thing = expectedEntry.getKey();
            Long amount = expectedEntry.getValue();
            assertThat(actualThingsAsMap)
                .as(entryAssertDescription.apply(thing))
                .containsEntry(thing, amount);
        });
    }

    private <T> Map<T, Long> asMap(Iterable<T> things) {
        return newArrayList(things)
            .stream()
            .collect(groupingBy(thing -> thing, counting()));
    }
}
