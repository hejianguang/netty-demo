package com.foo.service.headFirst.观察者模式;

import java.util.Observable;

/**
 * @author: he
 * @date: 2019/3/14
 */
public class WeatherData1 extends Observable {

    private float temperature;
    private float humidity;
    private float pressure;


    public void changed(){
        changed();
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        changed();
    }



    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
