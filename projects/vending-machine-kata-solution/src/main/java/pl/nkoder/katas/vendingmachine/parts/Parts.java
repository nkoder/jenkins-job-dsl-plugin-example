package pl.nkoder.katas.vendingmachine.parts;

import pl.nkoder.katas.vendingmachine.parts.display.Display;
import pl.nkoder.katas.vendingmachine.parts.money.Coin;
import pl.nkoder.katas.vendingmachine.parts.shelves.Shelves;
import pl.nkoder.katas.vendingmachine.products.Product;
import pl.nkoder.katas.vendingmachine.tray.Tray;

public class Parts {

    private final Shelves shelves;
    private final Display display;
    private final Tray<Product> takeOutTray;
    private final Tray<Coin> returnedCoinsTray;

    public Parts(Shelves shelves, Display display, Tray<Product> takeOutTray, Tray<Coin> returnedCoinsTray) {
        this.shelves = shelves;
        this.display = display;
        this.takeOutTray = takeOutTray;
        this.returnedCoinsTray = returnedCoinsTray;
    }

    public Shelves shelves() {
        return shelves;
    }

    public Display display() {
        return display;
    }

    public Tray<Product> takeOutTray() {
        return takeOutTray;
    }

    public Tray<Coin> returnedCoinsTray() {
        return returnedCoinsTray;
    }
}
