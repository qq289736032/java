package com.jisen.工厂模式;

/**
 * Created by jisen on 2018/8/30.
 */
public class Benz extends Car {

    @Override
    public void run() {
        System.out.println("Benz开始启动了。。。。。");
    }

    @Override
    public void stop() {
        System.out.println("Benz停车了。。。。。");
    }
}
