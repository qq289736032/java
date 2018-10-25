package com.jisen.test;

/**
 * Created by jisen on 2018/10/23.
 */
public class impossable {
    /**
     * 类名可以小写
     */
    public static void main(String[] args) {
        int i=2;
        int a=0;
        a=i++ + ++i + i++ + ++i;
        System.out.println(a);
        System.out.println(i);

    }
}
