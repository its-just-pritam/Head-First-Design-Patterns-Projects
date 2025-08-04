package org.design.app;

import lombok.extern.slf4j.Slf4j;
import org.design.observer.ObserverInterface;
import org.design.publisher.PublisherInterface;

@Slf4j
public class CurrentConditionsApp implements AppInterface, ObserverInterface {

    private final PublisherInterface publisherInterface;
    private Integer temperature;
    private Integer humidity;
    private Integer pressure;

    public CurrentConditionsApp(PublisherInterface publisherInterface) {
        this.publisherInterface = publisherInterface;
    }

    @Override
    public void start() {
        log.info("CurrentConditionsApp started");
        this.publisherInterface.subscribe(this);
    }

    @Override
    public void stop() {
        this.publisherInterface.unsubscribe(this);
        log.info("CurrentConditionsApp stopped");
    }

    @Override
    public void notifyObserver() {
        this.temperature = this.publisherInterface.getTemperature();
        this.humidity = this.publisherInterface.getHumidity();
        this.pressure = this.publisherInterface.getPressure();
        display();
    }

    @Override
    public void display() {

        log.info("+++++++ Conditions App dashboard +++++++");

        if(this.temperature == null)
            log.warn("Temperature data not available!");
        else
            log.info("Temperature = {} Degrees Celsius", this.temperature);

        if(this.humidity == null)
            log.warn("Humidity data not available!");
        else
            log.info("Humidity = {} %", this.humidity);

        if(this.pressure == null)
            log.warn("Pressure data not available!");
        else
            log.info("Pressure = {} bar", this.pressure);
    }
}
