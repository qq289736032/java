package com.jisen.单例模式;

/**
 * Created by jisen on 2018/8/30.
 * 将创建方法放在静态内部类
 */
public class Singleton4 {
    private static class SingletonHolder {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public static final Singleton4 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
