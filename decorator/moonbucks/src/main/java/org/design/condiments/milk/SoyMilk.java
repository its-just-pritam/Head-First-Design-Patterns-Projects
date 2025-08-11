package org.design.condiments.milk;

import org.design.base.Coffee;
import org.design.base.CoffeeSize;

import java.util.Map;
import java.util.Optional;

public class SoyMilk implements Coffee {

    private final Coffee coffee;

    public SoyMilk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public Map<String, Integer> description() {
        Map<String, Integer> desc = coffee.description();
        desc.put("Soy Milk", Optional.ofNullable(desc.get("Soy Milk")).orElse(0) + 1);
        return desc;
    }

    @Override
    public int cost() {
        return coffee.cost() + 65;
    }

    @Override
    public CoffeeSize size() {
        return coffee.size();
    }}
