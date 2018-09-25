package com.jisen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jisen on 2018/2/2.
 */
public class GJ {
    public static void main(String[] args) {
        //不用泛型时取出来的是Object,并且处处会给你黄线警告
        List list = new ArrayList();
        list.add("Hello");
        Object object = list.get(0);

        //使用泛型时取出来的是String
        List<String> list2 = new ArrayList<String>();
        list2.add("Hello");
        String string = list2.get(0);

        //泛型为什么不能用T,一定要显式的写出来?
        //List<T> list3 = new ArrayList<String>();//报错
    }
}
