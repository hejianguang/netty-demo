package com.foo.service.headFirst.观察者模式;

/**
 * @author: he
 * @date: 2019/3/14
 */
public interface Subject {


    public void registerObserver(Observer observer);

    public void removeObserver(Observer observer);

    public void notifyAllObservers();
}
