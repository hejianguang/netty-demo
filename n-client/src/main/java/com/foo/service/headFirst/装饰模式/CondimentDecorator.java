package com.foo.service.headFirst.装饰模式;

/**
 * 饮料装饰者
 * @author: he
 * @date: 2019/3/15
 */
public class CondimentDecorator extends Coffee{

    @Override
    double cost() {
        return 1;
    }
}
