package com.foo.service.headFirst.策略模式;

/**
 *
 * 用翅膀飞行为实现
 * @author: he
 * @date: 2019/3/14
 */
public class FlyBehaviorSwing implements FlyBehavior {

    @Override
    public void fly() {
        System.out.println("翅膀非的鸭子行为");
    }
}
