package pl.nkoder.katas.vendingmachine.states;

import pl.nkoder.katas.vendingmachine.parts.display.Display;
import pl.nkoder.katas.vendingmachine.parts.money.Coin;

public interface VendingMachineState {

    default void handleChoiceOfShelfNumber(int shelfNumber) {
    }

    default void handleCoinInsertion(Coin coin) {
    }

    default void handleCancellation() {
    }

    default void handleUpdateOf(Display display) {
    }

}
