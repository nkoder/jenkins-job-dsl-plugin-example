package pl.nkoder.katas.vendingmachine.parts.money;

import java.util.List;
import java.util.Optional;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

public class Coins {

    private List<Coin> listOfCoins = newArrayList();

    static Coins from(List<Coin> coinsToAdd) {
        Coins coins = new Coins();
        coinsToAdd.forEach(coin -> coins.add(coin));
        return coins;
    }

    public void add(Coin coin) {
        listOfCoins.add(coin);
    }

    public boolean haveCoinsOfValueOf(Cost cost) {
        return equivalentOf(cost).isPresent();
    }

    @SuppressWarnings("SuspiciousMethodCalls")
    public Optional<List<Coin>> takeEquivalentOf(Cost cost) {
        Optional<List<Coin>> optionalCoins = equivalentOf(cost).map(coins -> coins.asList());
        optionalCoins.ifPresent(coin -> listOfCoins.remove(coin));
        return optionalCoins;
    }

    private Optional<Coins> equivalentOf(Cost cost) {
        return new EquivalentOf(cost).using(this);
    }

    public List<Coin> asList() {
        return copyOf(listOfCoins);
    }

    private List<Coin> copyOf(List<Coin> coins) {
        return coins
            .stream()
            .map(coin -> coin)
            .collect(toList());
    }
}
