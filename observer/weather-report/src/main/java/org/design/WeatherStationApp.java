package org.design;

import lombok.extern.slf4j.Slf4j;
import org.design.app.AppInterface;
import org.design.app.CurrentConditionsApp;
import org.design.app.StatisticsApp;
import org.design.department.WeatherStationInterface;
import org.design.publisher.BangaloreWeatherStation;
import org.design.publisher.PublisherInterface;

import java.time.Instant;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

@Slf4j
public class WeatherStationApp {
    public static void main(String[] args) throws InterruptedException {

        WeatherStationInterface bangaloreWeatherStation = new BangaloreWeatherStation();
        AppInterface currentConditionsApp = new CurrentConditionsApp((PublisherInterface) bangaloreWeatherStation);
        AppInterface statisticsApp = new StatisticsApp((PublisherInterface) bangaloreWeatherStation);

        currentConditionsApp.start();
        statisticsApp.start();
        Thread.sleep(10000);

        long now = Instant.now().getEpochSecond();
        while (Instant.now().getEpochSecond() - now <=  60) {
            bangaloreWeatherStation.refresh();
            Thread.sleep(10000);
        }

        currentConditionsApp.stop();
        statisticsApp.stop();

        Thread.sleep(60000);
        currentConditionsApp.display();
        statisticsApp.display();
    }
}