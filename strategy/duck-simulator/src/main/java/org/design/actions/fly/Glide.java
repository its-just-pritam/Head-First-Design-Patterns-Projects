package org.design.actions.fly;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
public class Glide implements FlyAction {

    private Integer speed;

    private void glideWithWings() {
        log.info("The duck is gliding with wings @{}kmph", speed);
    }

    @Override
    public void execute() {
        glideWithWings();
    }
}
