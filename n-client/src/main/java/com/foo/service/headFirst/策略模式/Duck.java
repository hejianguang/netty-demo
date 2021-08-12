package com.foo.service.headFirst.策略模式;

/**
 * 鸭子抽象类
 * @author: he
 * @date: 2019/3/14
 */
public abstract class Duck {

    /**
     * 飞行行为
     */
    FlyBehavior flyBehavior;

    /**
     * 呱呱叫行为
     */
    QuackBehavior quackBehavior;

    /**
     * 抽象方法
     */
    public abstract void play();


    /**
     * 委托行为
     */
    public void performFly(){
        flyBehavior.fly();
    }

    public void performQuck(){
        quackBehavior.quack();
    }

    public FlyBehavior getFlyBehavior() {
        return flyBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public QuackBehavior getQuackBehavior() {
        return quackBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
}
