package pl.nkoder.katas.vendingmachine.parts.money;

import static pl.nkoder.katas.vendingmachine.parts.money.Cost.costOf;

@SuppressWarnings("unused")
public enum Coin {

    COIN_0_1(costOf("0.1")),
    COIN_0_2(costOf("0.2")),
    COIN_0_5(costOf("0.5")),
    COIN_1_0(costOf("1.0")),
    COIN_2_0(costOf("2.0")),
    COIN_5_0(costOf("5.0"));

    public final Cost value;

    Coin(Cost value) {
        this.value = value;
    }
}
