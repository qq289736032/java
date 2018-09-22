package com.jisen.装饰者模式;

/**
 * Created by jisen on 2018/8/30.
 * 装饰者模式:对已有的业务逻辑进一步封装,使其增加额外的功能,如Java中的io流就用了装饰者模式,用户在使用的时候可以任意组装
 */
public class Food {
    private String food_name;

    public Food() {
    }

    public Food(String food_name) {
        this.food_name = food_name;
    }

    public String make() {
        return food_name;
    };
}
