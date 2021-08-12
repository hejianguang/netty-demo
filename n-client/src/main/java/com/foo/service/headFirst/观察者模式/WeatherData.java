package com.foo.service.headFirst.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: he
 * @date: 2019/3/14
 */
public class WeatherData implements Subject {
    private List<Observer> observers;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observers.indexOf(observer) > 0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyAllObservers() {
        observers.forEach(observer->{
            observer.update(temp, humidity, pressure);
        });

    }


    public void settlementChanged(){
        notifyAllObservers();
    }


    public void setMeasureMennt(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        settlementChanged();
    }


    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }
}
