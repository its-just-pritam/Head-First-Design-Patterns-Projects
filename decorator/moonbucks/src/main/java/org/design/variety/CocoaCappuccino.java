package org.design.variety;

import org.design.base.Coffee;
import org.design.base.CoffeeSize;

import java.util.HashMap;
import java.util.Map;

public class CocoaCappuccino implements Coffee {

    private final CoffeeSize coffeeSize;

    public CocoaCappuccino(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    @Override
    public Map<String, Integer> description() {
        return new HashMap<>(Map.of("CocoaCappuccino", 1));
    }

    @Override
    public int cost() {
        if(this.coffeeSize == CoffeeSize.PICCO)
            return 315;
        else if (this.coffeeSize == CoffeeSize.SHORT)
            return 345;
        else if (this.coffeeSize == CoffeeSize.TALL)
            return 380;
        else if (this.coffeeSize == CoffeeSize.GRANDE)
            return 420;
        else if (this.coffeeSize == CoffeeSize.VENTI)
            return 460;
        else
            return 0;
    }

    @Override
    public CoffeeSize size() {
        return this.coffeeSize;
    }
}
