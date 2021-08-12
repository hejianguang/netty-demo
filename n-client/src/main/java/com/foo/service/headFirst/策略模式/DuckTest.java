package com.foo.service.headFirst.策略模式;

/**
 * @author: he
 * @date: 2019/3/14
 */
public class DuckTest {

    public static void main(String[] args){
        Duck duck = new YeQuack();
        duck.setFlyBehavior(new FlyBehaviorSwing());
        duck.performFly();
        duck.performQuck();
    }
}
