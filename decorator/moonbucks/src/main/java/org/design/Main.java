package org.design;

import lombok.extern.slf4j.Slf4j;
import org.design.base.Coffee;
import org.design.base.CoffeeSize;
import org.design.condiments.milk.SkimmedMilk;
import org.design.condiments.syrup.CaramelDrizzle;
import org.design.condiments.syrup.VanillaSyrup;
import org.design.variety.HazlenutCaffeLatte;

import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@Slf4j
public class Main {
    public static void main(String[] args) {

        log.info("Creating a coffee");

        Coffee coffee = new HazlenutCaffeLatte(CoffeeSize.GRANDE);
        coffee = new SkimmedMilk(coffee);
        coffee = new SkimmedMilk(coffee);
        coffee = new VanillaSyrup(coffee);
        coffee = new CaramelDrizzle(coffee);

        Map<String, Integer> desc = coffee.description();
        Integer cost = coffee.cost();

        AtomicReference<String> description = new AtomicReference<>("");
        desc.forEach((name, qty) -> description.set(description.get() + ((qty == 1) ? name : name + " (x" + qty + ")") + ", "));

        log.info("{} : Rs {}/-", description.get(), cost);

    }
}