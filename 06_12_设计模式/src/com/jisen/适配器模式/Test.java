package com.jisen.适配器模式;

/**
 * Created by jisen on 2018/8/30.
 */
public class Test {
    public static void main(String[] args) {
        Phone phone = new Phone();
        VoltageAdapter adapter = new VoltageAdapter();
        phone.setAdapter(adapter);
        phone.charge();
    }
}
