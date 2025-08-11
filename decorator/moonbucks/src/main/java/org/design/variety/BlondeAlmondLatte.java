package org.design.variety;

import org.design.base.Coffee;
import org.design.base.CoffeeSize;

import java.util.HashMap;
import java.util.Map;

public class BlondeAlmondLatte implements Coffee {

    private final CoffeeSize coffeeSize;

    public BlondeAlmondLatte(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    @Override
    public Map<String, Integer> description() {
        return new HashMap<>(Map.of("Blonde Almond Latte", 1));
    }

    @Override
    public int cost() {
        if(this.coffeeSize == CoffeeSize.PICCO)
            return 385;
        else if (this.coffeeSize == CoffeeSize.SHORT)
            return 435;
        else if (this.coffeeSize == CoffeeSize.TALL)
            return 470;
        else if (this.coffeeSize == CoffeeSize.GRANDE)
            return 510;
        else if (this.coffeeSize == CoffeeSize.VENTI)
            return 550;
        else
            return 0;
    }

    @Override
    public CoffeeSize size() {
        return this.coffeeSize;
    }
}
