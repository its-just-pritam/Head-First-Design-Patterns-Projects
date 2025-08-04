package org.design.app;

import lombok.extern.slf4j.Slf4j;
import org.design.observer.ObserverInterface;
import org.design.publisher.PublisherInterface;

import static java.lang.Math.max;
import static java.lang.Math.min;

@Slf4j
public class StatisticsApp implements AppInterface, ObserverInterface {

    private final PublisherInterface publisherInterface;
    private Integer totalReadings;

    private Integer minTemperature;
    private Integer minHumidity;
    private Integer minPressure;

    private Integer maxTemperature;
    private Integer maxHumidity;
    private Integer maxPressure;

    private Integer meanTemperature;
    private Integer meanHumidity;
    private Integer meanPressure;

    public StatisticsApp(PublisherInterface publisherInterface) {
        this.publisherInterface = publisherInterface;
        this.totalReadings = 0;

        this.minTemperature = 0;
        this.minHumidity = 0;
        this.minPressure = 0;

        this.maxTemperature = 0;
        this.maxHumidity = 0;
        this.maxPressure = 0;

        this.meanTemperature = 0;
        this.meanHumidity = 0;
        this.meanPressure = 0;
    }

    @Override
    public void start() {
        log.info("StatisticsApp started");
        this.publisherInterface.subscribe(this);
    }

    @Override
    public void stop() {
        this.publisherInterface.unsubscribe(this);
        log.info("StatisticsApp stopped");
    }

    @Override
    public void notifyObserver() {

        Integer temperature = publisherInterface.getTemperature();
        Integer humidity = publisherInterface.getHumidity();
        Integer pressure = publisherInterface.getPressure();

        this.minTemperature = min(this.minTemperature, temperature);
        this.minHumidity = min(this.minHumidity, humidity);
        this.minPressure = min(this.minPressure, pressure);

        this.maxTemperature = max(this.maxTemperature, temperature);
        this.maxHumidity = max(this.maxHumidity, humidity);
        this.maxPressure = max(this.maxPressure, pressure);

        this.meanTemperature = (this.meanTemperature * this.totalReadings + temperature) / (this.totalReadings + 1);
        this.meanHumidity = (this.meanHumidity * this.totalReadings + humidity) / (this.totalReadings + 1);
        this.meanPressure = (this.meanPressure * this.totalReadings + pressure) / (this.totalReadings + 1);

        this.totalReadings += 1;
        display();
    }

    @Override
    public void display() {

        log.info("+++++++ Statistics App dashboard +++++++");

        displayMax();
        displayMin();
        displayMean();
    }

    private void displayMin() {
        log.info("Min Temperature: {} Degree Celsius", this.minTemperature);
        log.info("Min Humidity: {} %", this.minHumidity);
        log.info("Min Pressure: {} bar", this.minPressure);
    }

    private void displayMax() {
        log.info("Max Temperature: {} Degree Celsius", this.maxTemperature);
        log.info("Max Humidity: {} %", this.maxHumidity);
        log.info("Max Pressure: {} bar", this.maxPressure);
    }

    private void displayMean() {
        log.info("Mean Temperature: {} Degree Celsius", this.meanTemperature);
        log.info("Mean Humidity: {} %", this.meanHumidity);
        log.info("Mean Pressure: {} bar", this.meanPressure);
    }
}
