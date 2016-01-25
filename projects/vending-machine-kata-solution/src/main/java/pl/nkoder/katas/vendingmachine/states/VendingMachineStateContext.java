package pl.nkoder.katas.vendingmachine.states;

import pl.nkoder.katas.vendingmachine.parts.Parts;
import pl.nkoder.katas.vendingmachine.parts.money.Coin;
import pl.nkoder.katas.vendingmachine.parts.money.Coins;
import pl.nkoder.katas.vendingmachine.parts.money.Cost;
import pl.nkoder.katas.vendingmachine.products.Product;
import pl.nkoder.katas.vendingmachine.time.DelayedAction;
import pl.nkoder.katas.vendingmachine.time.DelayedActions;

import java.time.Duration;
import java.util.List;

public class VendingMachineStateContext {

    private final Parts parts;
    private final Coins allCoins;
    private final DelayedActions delayedActions;

    private VendingMachineState state;

    public VendingMachineStateContext(Parts parts, Coins allCoins, DelayedActions delayedActions) {
        this.parts = parts;
        this.allCoins = allCoins;
        this.delayedActions = delayedActions;
        changeStateTo(new WaitingForShelfChoiceState(this));
    }

    public VendingMachineState currentState() {
        return state;
    }

    public void changeStateTo(VendingMachineState nextState) {
        state = nextState;
        state.handleUpdateOf(parts.display());
    }

    public Cost priceOfProductAtShelf(int shelfNumber) {
        return parts.shelves().priceOfProductAtShelf(shelfNumber);
    }

    public Product productAtShelf(int shelfNumber) {
        return parts.shelves().productAtShelf(shelfNumber);
    }

    public void addCoin(Coin coin) {
        allCoins.add(coin);
    }

    public boolean hasAvailableCoinsOfValueOf(Cost cost) {
        return allCoins.haveCoinsOfValueOf(cost);
    }

    public List<Coin> takeCoinsOfValueOf(Cost cost) {
        return allCoins.takeEquivalentOf(cost).get();
    }

    public void sellProductAtShelf(int shelfNumber) {
        parts.takeOutTray().put(productAtShelf(shelfNumber));
    }

    public void returnCoins(List<Coin> coins) {
        coins.forEach(takenCoin -> parts.returnedCoinsTray().put(takenCoin));
    }

    public DelayedAction after(Duration duration) {
        return delayedActions.after(duration);
    }
}
