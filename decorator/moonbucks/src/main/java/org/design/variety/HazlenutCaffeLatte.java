package org.design.variety;

import org.design.base.Coffee;
import org.design.base.CoffeeSize;

import java.util.HashMap;
import java.util.Map;

public class HazlenutCaffeLatte implements Coffee {

    private final CoffeeSize coffeeSize;

    public HazlenutCaffeLatte(CoffeeSize coffeeSize) {
        this.coffeeSize = coffeeSize;
    }

    @Override
    public Map<String, Integer> description() {
        return new HashMap<>(Map.of("Hazlenut Caffe Latte", 1));
    }

    @Override
    public int cost() {
        if(this.coffeeSize == CoffeeSize.PICCO)
            return 305;
        else if (this.coffeeSize == CoffeeSize.SHORT)
            return 335;
        else if (this.coffeeSize == CoffeeSize.TALL)
            return 370;
        else if (this.coffeeSize == CoffeeSize.GRANDE)
            return 410;
        else if (this.coffeeSize == CoffeeSize.VENTI)
            return 450;
        else
            return 0;
    }

    @Override
    public CoffeeSize size() {
        return this.coffeeSize;
    }
}
