package com.foo.service.headFirst.装饰模式;

/**
 * @author: he
 * @date: 2019/3/15
 */
public class DiCoffee extends CondimentDecorator {

    public DiCoffee() {
        desc = "this is a di Coffee";
    }

    @Override
    double cost() {
        return super.cost() + 0.1;
    }
}
