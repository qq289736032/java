package com.jisen;

import java.util.*;

/**
 * Created by jisen on 2018/4/12.
 */

public class TestList {
    public static void main(String[] args) {
        List list1 = new ArrayList();
        list1.add(1);//在数组的尾端加一个元素
        list1.get(0);
        Iterator iterator = list1.iterator();//迭代
        list1.addAll(list1);//用arraycopy建一个新数组

        List list2 = new LinkedList();
        list2.add(2);
//        list2.sort();


        list2.get(0);
        list2.addAll(list2);


        List list3 = new Vector();
        list3.add(2);
        list3.get(0);
        list3.addAll(list3);

        ThreadLocal tl = new ThreadLocal();
        tl.set("aaa");

    }
}
