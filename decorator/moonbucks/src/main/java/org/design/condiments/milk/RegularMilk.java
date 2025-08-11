package org.design.condiments.milk;

import org.design.base.Coffee;
import org.design.base.CoffeeSize;

import java.util.Map;
import java.util.Optional;

public class RegularMilk implements Coffee {

    private final Coffee coffee;

    public RegularMilk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public Map<String, Integer> description() {
        Map<String, Integer> desc = coffee.description();
        desc.put("Regular Milk", Optional.ofNullable(desc.get("Regular Milk")).orElse(0) + 1);
        return desc;
    }

    @Override
    public int cost() {
        return coffee.cost();
    }

    @Override
    public CoffeeSize size() {
        return coffee.size();
    }}
