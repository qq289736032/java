package com.jisen.工厂模式;

/**
 * Created by jisen on 2018/8/30.
 */
public class Ford extends Car {

    @Override
    public void run() {
        System.out.println("Ford开始启动了。。。。。");
    }

    @Override
    public void stop() {
        System.out.println("Ford停车了。。。。。");
    }
}
