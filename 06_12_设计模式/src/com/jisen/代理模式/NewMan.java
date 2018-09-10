package com.jisen.代理模式;

/**
 * Created by jisen on 2018/8/30.
 */
public class NewMan implements ProxyInterface {
    @Override
    public void marry() {
        System.out.println("结婚了");
    }
}
