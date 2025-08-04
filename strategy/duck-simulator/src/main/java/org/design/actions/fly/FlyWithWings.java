package org.design.actions.fly;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class FlyWithWings implements FlyAction {

    private Integer speed;

    private void flyWithWings() {
        log.info("The duck is flying with wings @{}kmph", speed);
    }

    @Override
    public void execute() {
        flyWithWings();
    }
}
