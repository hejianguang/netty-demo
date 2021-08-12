package com.foo.service.headFirst.装饰模式;

/**
 * @author: he
 * @date: 2019/3/15
 */
public abstract class Coffee {


    String desc = "this is coffee";

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    abstract double cost();
}
