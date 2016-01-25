package pl.nkoder.katas.vendingmachine.states;

import pl.nkoder.katas.vendingmachine.parts.display.Display;
import pl.nkoder.katas.vendingmachine.parts.money.Coin;

import java.time.Duration;

import static com.google.common.collect.Lists.newArrayList;

public class UnableToReturnChangeState implements VendingMachineState {

    private static final Duration DURATION_OF_WARNING_MESSAGE = Duration.ofSeconds(3);

    private final VendingMachineStateContext context;

    public UnableToReturnChangeState(VendingMachineStateContext context) {
        this.context = context;
        context
            .after(DURATION_OF_WARNING_MESSAGE)
            .perform(() -> context.changeStateTo(new WaitingForShelfChoiceState(context)));
    }

    @Override
    public void handleCoinInsertion(Coin coin) {
        context.returnCoins(newArrayList(coin));
    }

    @Override
    public void handleUpdateOf(Display display) {
        display.warnAboutNoChange();
    }

}
