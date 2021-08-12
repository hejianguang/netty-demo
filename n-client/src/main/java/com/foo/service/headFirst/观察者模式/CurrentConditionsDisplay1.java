package com.foo.service.headFirst.观察者模式;

import java.util.Observable;
import java.util.Observer;

/**
 * @author: he
 * @date: 2019/3/14
 */
public class CurrentConditionsDisplay1 implements Observer, Display{

    private float temp;
    private float humidity;
    private float pressure;

    Observable observable;

    public CurrentConditionsDisplay1(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData1) {
            WeatherData1 weatherData = (WeatherData1)o;
            this.temp = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }


    @Override
    public void display() {
        System.out.println("面板1:" +temp+ ";"+humidity+";"+ pressure);
    }
}
