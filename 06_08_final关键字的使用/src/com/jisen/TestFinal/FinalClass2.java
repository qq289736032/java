package com.jisen.TestFinal;

/**
 * @Desc TODO
 * @Author Administrator
 * @Date 2018/12/26 15:34
 */
public class FinalClass2 extends FinalClass {


    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String getAge() {
        System.out.println(super.getAge());
        return "25";
    }

    @Override
    public void setAge(String age) {
        super.setAge(age);
    }
}
