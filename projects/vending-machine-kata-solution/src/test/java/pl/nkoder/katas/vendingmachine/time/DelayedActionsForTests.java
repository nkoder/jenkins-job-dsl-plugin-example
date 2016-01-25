package pl.nkoder.katas.vendingmachine.time;

import java.time.Duration;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class DelayedActionsForTests extends DelayedActions {

    private List<DelayedAction> delayedActions = newArrayList();

    @Override
    public DelayedAction after(Duration duration) {
        DelayedAction delayedAction = super.after(duration);
        delayedActions.add(delayedAction);
        return delayedAction;
    }

    public void performAll() {
        delayedActions
            .stream()
            .forEach(delayedAction -> delayedAction.complete());
    }
}
