package pl.nkoder.katas.vendingmachine.time;

import java.time.Duration;

public class DelayedActions {

    public DelayedAction after(Duration duration) {
        return new DelayedAction(duration);
    }

}
