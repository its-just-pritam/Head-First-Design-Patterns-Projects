package org.design.variety;

import org.design.base.Coffee;
import org.design.base.CoffeeSize;

import java.util.HashMap;
import java.util.Map;

public class Latte implements Coffee {

    private final CoffeeSize coffeeSize;

    public Latte(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    @Override
    public Map<String, Integer> description() {
        return new HashMap<>(Map.of("Latte", 1));
    }

    @Override
    public int cost() {
        return 220;
    }

    @Override
    public CoffeeSize size() {
        return this.coffeeSize;
    }
}
