package org.design.condiments.syrup;

import org.design.base.Coffee;
import org.design.base.CoffeeSize;

import java.util.Map;
import java.util.Optional;

public class CaramelSauce implements Coffee {

    private final Coffee coffee;

    public CaramelSauce(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public Map<String, Integer> description() {
        Map<String, Integer> desc = coffee.description();
        desc.put("Caramel Sauce", Optional.ofNullable(desc.get("Caramel Sauce")).orElse(0) + 1);
        return desc;
    }

    @Override
    public int cost() {
        return coffee.cost() + 55;
    }

    @Override
    public CoffeeSize size() {
        return coffee.size();
    }
}
