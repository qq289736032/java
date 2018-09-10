package com.jisen.观察者模式;

/**
 * Created by jisen on 2018/8/30.
 */
public class LaoWang implements Person {
    private String name = "老王";

    public LaoWang() {
    }

    @Override
    public void getMessage(String s) {
        System.out.println(name + "接到了小美打过来的电话，电话内容是：" + s);
    }
}
