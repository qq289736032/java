package com.jisen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by jisen on 2018/2/2.
 */
public class TestArray {

    public static void main(String[] args) {
        A[] arr1 = new B[10];
        A[] arr2 = new A[10];
        arr2[0] = new B();

        //ArrayList<T> list = new ArrayList<T>();
        //list.add(new A());
        //list.add(new B());
        List integerList = new ArrayList<Integer>();
        //List<Number> num = integerList;

        Object[] array = new Integer[10];
        array[0] = "s String";
    }
}
