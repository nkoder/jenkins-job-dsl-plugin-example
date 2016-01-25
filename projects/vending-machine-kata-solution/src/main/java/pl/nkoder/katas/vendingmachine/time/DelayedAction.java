package pl.nkoder.katas.vendingmachine.time;

import com.google.common.annotations.VisibleForTesting;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;

public class DelayedAction {

    private final Clock clock = new Clock();
    private final CompletableFuture<Void> completableFuture = new CompletableFuture<>();

    private long startTimeInSeconds;

    public DelayedAction(Duration duration) {
        rememberStartTime();
        new Thread(() -> {
            while (isStillWaitingForEndOf(duration)) {
                waitALittleMore();
            }
            complete();
        }).start();
    }

    public void perform(Runnable action) {
        completableFuture.thenApply(object -> {
            action.run();
            return null;
        });
    }

    private void rememberStartTime() {
        this.startTimeInSeconds = clock.timeInSeconds();
    }

    private boolean isStillWaitingForEndOf(Duration duration) {
        return startTimeInSeconds + duration.getSeconds() > clock.timeInSeconds();
    }

    private void waitALittleMore() {
        try {
            Thread.sleep(oneTenthOfSecond().toMillis());
        } catch (InterruptedException ignoredException) {
        }
    }

    @VisibleForTesting
    void complete() {
        completableFuture.complete(null);
    }

    private Duration oneTenthOfSecond() {
        return Duration.ofSeconds(1).dividedBy(10);
    }
}
