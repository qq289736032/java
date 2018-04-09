package com.jisen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jisen on 2018/2/27.
 */
public class GJ {

    public static void main(String[] args) {
        //泛型擦除
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println("c1ClassName:"+c1.getName());    //c1ClassName:java.util.ArrayList
        System.out.println("c2ClassName"+c2.getName());     //c2ClassNamejava.util.ArrayList
        System.out.println(c1 == c2);//true
        String sql =null;
        StringBuilder sb = new StringBuilder(sql);
        System.out.println(sb);
    }
}
