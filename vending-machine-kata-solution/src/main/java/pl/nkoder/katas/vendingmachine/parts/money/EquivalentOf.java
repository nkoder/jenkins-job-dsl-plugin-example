package pl.nkoder.katas.vendingmachine.parts.money;

import java.util.List;
import java.util.Optional;

import static pl.nkoder.katas.vendingmachine.parts.money.Cost.costOf;

public class EquivalentOf {

    private final Cost cost;

    public EquivalentOf(Cost cost) {
        this.cost = cost;
    }

    public Optional<Coins> using(Coins availableCoins) {
        if (costIsZero()) {
            return coinsOfValueZero();
        }
        for (Coin coin : availableCoins.asList()) {
            if (costIsNotLessThanValueOf(coin)) {
                Coins restOfCoins = subtract(availableCoins, coin);
                Cost restOfCost = costMinusValueOf(coin);
                Optional<Coins> restOfEquivalent = new EquivalentOf(restOfCost).using(restOfCoins);
                if (restOfEquivalent.isPresent()) {
                    Coins coinsEquivalentToCost = add(restOfEquivalent.get(), coin);
                    return Optional.of(coinsEquivalentToCost);
                }
            }
        }
        return Optional.empty();
    }

    private boolean costIsZero() {
        return cost.isEqualTo(costOf("0"));
    }

    private boolean costIsNotLessThanValueOf(Coin coin) {
        return !cost.isLessThan(coin.value);
    }

    private Cost costMinusValueOf(Coin coin) {
        return cost.subtract(coin.value);
    }

    private Optional<Coins> coinsOfValueZero() {
        return Optional.of(new Coins());
    }

    private Coins add(Coins coins, Coin coin) {
        List<Coin> result = coins.asList();
        result.add(coin);
        return Coins.from(result);
    }

    private Coins subtract(Coins coins, Coin coinToRemove) {
        List<Coin> result = coins.asList();
        result.remove(coinToRemove);
        return Coins.from(result);
    }

}
