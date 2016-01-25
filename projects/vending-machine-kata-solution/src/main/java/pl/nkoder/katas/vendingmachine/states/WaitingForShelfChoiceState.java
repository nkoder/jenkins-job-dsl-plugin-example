package pl.nkoder.katas.vendingmachine.states;

import pl.nkoder.katas.vendingmachine.parts.display.Display;
import pl.nkoder.katas.vendingmachine.parts.money.Coin;

import static com.google.common.collect.Lists.newArrayList;

public class WaitingForShelfChoiceState implements VendingMachineState {

    private final VendingMachineStateContext context;

    public WaitingForShelfChoiceState(VendingMachineStateContext context) {
        this.context = context;
    }

    @Override
    public void handleChoiceOfShelfNumber(int shelfNumber) {
        context.changeStateTo(new InsertingCoinsState(shelfNumber, context));
    }

    @Override
    public void handleCoinInsertion(Coin coin) {
        context.returnCoins(newArrayList(coin));
    }

    @Override
    public void handleUpdateOf(Display display) {
        display.promptForProductChoice();
    }
}
