package pl.nkoder.katas.vendingmachine.states;

import pl.nkoder.katas.vendingmachine.parts.display.Display;
import pl.nkoder.katas.vendingmachine.parts.money.Coin;
import pl.nkoder.katas.vendingmachine.parts.money.Cost;

import java.util.List;

import static pl.nkoder.katas.vendingmachine.parts.money.Cost.costOf;

public class InsertingCoinsState implements VendingMachineState {

    private final VendingMachineStateContext context;
    private final int chosenShelfNumber;
    private final Cost insertedCoinsValue;

    public InsertingCoinsState(int chosenShelfNumber, VendingMachineStateContext context) {
        this(costOf("0"), chosenShelfNumber, context);
    }

    private InsertingCoinsState(Cost insertedCoinsValue, int chosenShelfNumber, VendingMachineStateContext context) {
        this.context = context;
        this.insertedCoinsValue = insertedCoinsValue;
        this.chosenShelfNumber = chosenShelfNumber;
    }

    @Override
    public void handleCoinInsertion(Coin coin) {
        context.addCoin(coin);
        Cost newInsertedValue = insertedCoinsValue.add(coin.value);
        VendingMachineState nextState;
        if (isNotEnoughToSellProduct(newInsertedValue)) {
            nextState = new InsertingCoinsState(newInsertedValue, chosenShelfNumber, context);
            context.changeStateTo(nextState);
            return;
        }
        Cost change = changeToReturnWhenInsertedValueIs(newInsertedValue);
        if (isPossibleToReturnCoinsOfValueOf(change)) {
            sellProduct();
            returnCoinsOfValueOf(change);
            nextState = new WaitingForShelfChoiceState(context);
            context.changeStateTo(nextState);
            return;
        }
        returnCoinsOfValueOf(newInsertedValue);
        nextState = new UnableToReturnChangeState(context);
        context.changeStateTo(nextState);
    }

    private boolean isNotEnoughToSellProduct(Cost newInsertedValue) {
        return newInsertedValue.isLessThan(productPrice());
    }

    private Cost changeToReturnWhenInsertedValueIs(Cost newInsertedValue) {
        return newInsertedValue.subtract(productPrice());
    }

    private boolean isPossibleToReturnCoinsOfValueOf(Cost change) {
        return context.hasAvailableCoinsOfValueOf(change);
    }

    private Cost productPrice() {
        return context.priceOfProductAtShelf(chosenShelfNumber);
    }

    @Override
    public void handleCancellation() {
        returnCoinsOfValueOf(insertedCoinsValue);
        context.changeStateTo(new WaitingForShelfChoiceState(context));
    }

    private void returnCoinsOfValueOf(Cost cost) {
        List<Coin> changeCoins = context.takeCoinsOfValueOf(cost);
        context.returnCoins(changeCoins);
    }

    private void sellProduct() {
        context.sellProductAtShelf(chosenShelfNumber);
    }

    @Override
    public void handleUpdateOf(Display display) {
        Cost productPrice = productPrice();
        Cost remainingCost = productPrice.subtract(insertedCoinsValue);
        display.promptForMoneyToInsert(remainingCost);
    }

}
