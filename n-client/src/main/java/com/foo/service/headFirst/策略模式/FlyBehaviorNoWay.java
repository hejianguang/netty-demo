package com.foo.service.headFirst.策略模式;

/**
 * @author: he
 * @date: 2019/3/14
 */
public class FlyBehaviorNoWay implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("这个鸭子不会飞");
    }
}
