package com.jisen.单例模式;

/**
 * Created by jisen on 2018/8/30.
 * 将创建方法放在静态内部类
 */
public class Singleton6 {
    private volatile static Singleton6 singleton;
    private Singleton6 (){}
    public static Singleton6 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton6.class) {
                if (singleton == null) {
                    singleton = new Singleton6();
                }
            }
        }
        return singleton;
    }
} 