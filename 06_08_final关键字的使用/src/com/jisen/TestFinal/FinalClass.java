package com.jisen.TestFinal;

/**
 * @Desc TODO
 * @Author Administrator
 * @Date 2018/12/26 15:32
 */
public class FinalClass {
    public final static String MAX_VALUE = "jisen";
    private final String name = "jisen123";
    private String age = "25";

    public static String getMaxValue() {
        return MAX_VALUE;
    }

    public final String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
