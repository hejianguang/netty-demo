package com.foo.service.headFirst.观察者模式;

/**
 * @author: he
 * @date: 2019/3/14
 */
public class StaticDispay implements Observer, Display {

    private float temp;
    private float humidity;
    private float pressure;

    private Subject weatherData;


    public StaticDispay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("面板2:" +temp+ ";"+humidity+";"+ pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity =humidity;
        this.pressure = pressure;
        display();
    }


    public Subject getWeatherData() {
        return weatherData;
    }
}
