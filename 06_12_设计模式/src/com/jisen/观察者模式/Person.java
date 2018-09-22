package com.jisen.观察者模式;

/**
 * Created by jisen on 2018/8/30.
 * 对象间一对多的依赖关系,当一个对象的 状态发生改变时,所有依赖于他的对象都得到通知并被自动更新
 */
public interface Person {
    void getMessage(String s);
}
