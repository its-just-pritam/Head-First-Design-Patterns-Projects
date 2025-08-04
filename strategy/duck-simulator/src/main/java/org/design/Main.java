package org.design;

import lombok.extern.slf4j.Slf4j;
import org.design.actions.fly.FlyWithWings;
import org.design.actions.quack.Quack;
import org.design.objects.BilledDuck;
import org.design.objects.Duck;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

@Slf4j
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        log.info("Hello and welcome!");

        Duck duck = new BilledDuck("Gary", new Quack(), new FlyWithWings(30));
        duck.display();
        duck.swim();
        duck.quack();
        duck.fly();

    }
}