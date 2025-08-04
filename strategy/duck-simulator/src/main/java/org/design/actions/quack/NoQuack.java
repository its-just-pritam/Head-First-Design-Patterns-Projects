package org.design.actions.quack;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NoQuack implements QuackAction {

    private void staySilent() {
        log.info("........");
    }

    @Override
    public void execute() {
        staySilent();
    }
}
