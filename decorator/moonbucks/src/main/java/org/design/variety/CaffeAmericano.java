package org.design.variety;

import org.design.base.Coffee;
import org.design.base.CoffeeSize;

import java.util.HashMap;
import java.util.Map;

public class CaffeAmericano implements Coffee {

    private final CoffeeSize coffeeSize;

    public CaffeAmericano(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    @Override
    public Map<String, Integer> description() {
        return new HashMap<>(Map.of("Caffe Americano", 1));
    }

    @Override
    public int cost() {
        if(this.coffeeSize == CoffeeSize.PICCO)
            return 220;
        else if (this.coffeeSize == CoffeeSize.SHORT)
            return 250;
        else if (this.coffeeSize == CoffeeSize.TALL)
            return 285;
        else if (this.coffeeSize == CoffeeSize.GRANDE)
            return 325;
        else if (this.coffeeSize == CoffeeSize.VENTI)
            return 365;
        else
            return 0;
    }

    @Override
    public CoffeeSize size() {
        return this.coffeeSize;
    }
}
