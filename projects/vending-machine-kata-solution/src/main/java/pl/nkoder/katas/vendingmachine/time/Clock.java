package pl.nkoder.katas.vendingmachine.time;

public class Clock {

    public long timeInSeconds() {
        return System.currentTimeMillis() / 1000;
    }
}
