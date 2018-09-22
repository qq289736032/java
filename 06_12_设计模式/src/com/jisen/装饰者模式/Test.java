package com.jisen.装饰者模式;

/**
 * Created by jisen on 2018/8/30.
 */
public class Test {
    public static void main(String[] args) {
        Food food = new Bread(new Vegetable(new Food("米饭")));
        System.out.println(food.make());
    }
}
