package com.foo.service.headFirst.观察者模式;

/**
 * @author: he
 * @date: 2019/3/14
 */
public class DisplayTest {

    /**
     * 气象台观察者模式 天气变化 自动同步到不同的面板
     * @param a
     */

    public static void main(String[] a){
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        StaticDispay staticDispay = new StaticDispay(weatherData);

        weatherData.setMeasureMennt(12f, 18f, 88f);

        staticDispay.getWeatherData().removeObserver(staticDispay);
        weatherData.setMeasureMennt(66f, 88f, 99f);

    }
}
