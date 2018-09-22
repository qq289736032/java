package com.jisen.单例模式;

/**
 * Created by jisen on 2018/8/30.
 * 线程安全
 */
public class Singleton2 {
    private static Singleton2 singleton;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (singleton == null) {
            singleton = new Singleton2();
        }
        return singleton;
    }
}
