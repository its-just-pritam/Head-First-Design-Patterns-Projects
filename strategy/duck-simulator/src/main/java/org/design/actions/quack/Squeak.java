package org.design.actions.quack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Squeak implements QuackAction {

    private void squeak() {
        log.info("Squeak squeak!!");
    }

    @Override
    public void execute() {
        squeak();
    }
}
