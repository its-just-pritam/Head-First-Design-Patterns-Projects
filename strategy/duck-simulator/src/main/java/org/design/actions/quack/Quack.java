package org.design.actions.quack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Quack implements QuackAction {

    private void quack() {
        log.info("Quack quack!!");
    }

    @Override
    public void execute() {
        quack();
    }
}
