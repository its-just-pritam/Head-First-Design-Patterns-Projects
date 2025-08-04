package org.design.publisher;

import lombok.extern.slf4j.Slf4j;
import org.design.department.WeatherStationInterface;
import org.design.observer.ObserverInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
public class BangaloreWeatherStation implements PublisherInterface, WeatherStationInterface {

    private List<ObserverInterface> subscribers;
    private Integer temperature;
    private Integer humidity;
    private Integer pressure;
    private final Random random;

    public BangaloreWeatherStation() {
        this.subscribers = new ArrayList<>();
        this.temperature = 0;
        this.humidity = 0;
        this.pressure = 0;
        this.random = new Random();
    }

    @Override
    public void subscribe(ObserverInterface observer) {
        log.info("Adding subscriber");
        subscribers.add(observer);
    }

    @Override
    public void unsubscribe(ObserverInterface observer) {
        subscribers.remove(observer);
        log.info("Removing subscriber");
    }

    @Override
    public Integer getTemperature() {
        return this.temperature;
    }

    @Override
    public Integer getHumidity() {
        return this.humidity;
    }

    @Override
    public Integer getPressure() {
        return this.pressure;
    }

    @Override
    public void refresh() {

        log.info("Refreshing BangaloreWeatherStation");
        this.temperature = random.nextInt(20) + 20;
        this.humidity = random.nextInt(50) + 50;
        this.pressure = random.nextInt(2) + 1;

        for (ObserverInterface observer: this.subscribers)
            observer.notifyObserver();
    }
}
