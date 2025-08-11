package org.design.condiments.milk;

import org.design.base.Coffee;
import org.design.base.CoffeeSize;

import java.util.Map;
import java.util.Optional;

public class SkimmedMilk implements Coffee {

    private final Coffee coffee;

    public SkimmedMilk(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public Map<String, Integer> description() {
        Map<String, Integer> desc = coffee.description();
        desc.put("Skimmed Milk", Optional.ofNullable(desc.get("Skimmed Milk")).orElse(0) + 1);
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
