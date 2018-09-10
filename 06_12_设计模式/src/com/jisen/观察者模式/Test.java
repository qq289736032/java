package com.jisen.观察者模式;

/**
 * Created by jisen on 2018/8/30.
 */
public class Test {
    public static void main(String[] args) {
        LaoWang lao_wang = new LaoWang();
        LaoLi lao_li = new LaoLi();

        XiaoMei xiao_mei = new XiaoMei();
        xiao_mei.addPerson(lao_wang);
        xiao_mei.addPerson(lao_li);

        xiao_mei.notifyPerson();

    }
}
