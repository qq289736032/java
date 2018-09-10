package com.jisen.适配器模式;

/**
 * Created by jisen on 2018/8/30.
 */
public class VoltageAdapter {
    public void changeVoltage() {
        System.out.println("正在充电...");
        System.out.println("原始电压：" + Phone.V + "V");
        System.out.println("经过变压器转换之后的电压:" + (Phone.V - 200) + "V");
    }
}
