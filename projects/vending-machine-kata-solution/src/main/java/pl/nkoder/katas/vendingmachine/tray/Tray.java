package pl.nkoder.katas.vendingmachine.tray;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

public class Tray<T> {

    private List<T> things = newArrayList();

    public void put(T thing) {
        things.add(thing);
    }

    public Iterable<T> listAll() {
        return things;
    }

    public Iterable<T> takeAll() {
        Iterable<T> result = newArrayList(things);
        things.clear();
        return result;
    }

    public void removeAll() {
        things.clear();
    }
}
