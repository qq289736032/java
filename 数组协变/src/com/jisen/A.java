package com.jisen;

/**
 * Created by jisen on 2018/2/2.
 */
public class A {
    //静态方法重载,但不能重写
    public static int method(){
        return 3*2;
    }
    public static int method(int a,int b){
        return a*b;
    }
    //普通方法可以重载可以重写
    public void print(){
        System.out.println("I am printmethod");
    }
    public void print(int i){
        if(i>5)
        System.out.println("I am printmethod");
    }



}
