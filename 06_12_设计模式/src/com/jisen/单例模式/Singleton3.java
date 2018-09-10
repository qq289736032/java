package com.jisen.单例模式;

/**
 * Created by jisen on 2018/8/30.
 * 饿汉式
 */
public class Singleton3 {
    private static Singleton3 singleton = new Singleton3();

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        return singleton;
    }
}
