package com.jisen.适配器模式;

/**
 * Created by jisen on 2018/8/30.
 * 两种完全不同的事物联系到一起,类似万能充电器,将不能直接应用与产品的电能转换为可以使用的电能
 */
public class Phone {
    public static final int V = 220;// 正常电压220v，是一个常量

    private VoltageAdapter adapter;

    // 充电
    public void charge() {
        adapter.changeVoltage();
    }

    public void setAdapter(VoltageAdapter adapter) {
        this.adapter = adapter;
    }
}
