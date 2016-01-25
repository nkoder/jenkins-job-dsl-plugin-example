package pl.nkoder.katas.vendingmachine.parts.display;

import pl.nkoder.katas.vendingmachine.parts.money.Cost;

import static java.lang.String.format;

public class Display {

    private String message;

    public String message() {
        return message;
    }

    public void promptForProductChoice() {
        message = "Wybierz produkt";
    }

    public void warnAboutNoChange() {
        message = "Nie mogę wydać reszty. Zakup anulowany.";
    }

    public void promptForMoneyToInsert(Cost cost) {
        message = format("Wrzuć %s", cost.asText());
    }
}
