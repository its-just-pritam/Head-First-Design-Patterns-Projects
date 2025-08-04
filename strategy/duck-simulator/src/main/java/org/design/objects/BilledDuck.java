package org.design.objects;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.design.actions.fly.FlyAction;
import org.design.actions.quack.QuackAction;

@Slf4j
@AllArgsConstructor
public class BilledDuck extends Duck {

    private String name;
    private QuackAction quackAction;
    private FlyAction flyAction;

    @Override
    public void swim() {
        log.info("{} the duck is swimming in a pond", name);
    }

    @Override
    public void display() {
        log.info("{} the duck is spawned in white, with black spots on the chest", name);
    }

    @Override
    public void quack() {
        quackAction.execute();
    }

    @Override
    public void fly() {
        flyAction.execute();
    }
}
