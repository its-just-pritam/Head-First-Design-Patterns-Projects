package org.design.actions.fly;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
public class NotFlyable implements FlyAction {

    private void failedToFly() {
        log.info("The duck can't fly");
    }

    @Override
    public void execute() {
        failedToFly();
    }
}
