package com.foo.service.headFirst.装饰模式;

/**
 * @author: he
 * @date: 2019/3/15
 */
public class Test {

    public static void main(String[] a){
        DiCoffee diCoffee = new DiCoffee();

        System.out.println(diCoffee.cost());
        System.out.println(diCoffee.desc);
    }
}
