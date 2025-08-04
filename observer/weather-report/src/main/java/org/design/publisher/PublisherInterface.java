package org.design.publisher;

import org.design.observer.ObserverInterface;

public interface PublisherInterface {

    void subscribe(ObserverInterface observer);

    void unsubscribe(ObserverInterface observer);

    Integer getTemperature();

    Integer getHumidity();

    Integer getPressure();


}
