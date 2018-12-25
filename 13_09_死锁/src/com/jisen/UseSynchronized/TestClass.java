package com.jisen.UseSynchronized;

/**
 * @Desc TODO
 * @Author Administrator
 * @Date 2018/12/25 10:42
 */
public class TestClass {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Thread t1= new Thread(new Runnable() {
                @Override
                public void run() {
                    myClass.method1();
                }

        });
        Thread t2= new Thread(new Runnable() {
            @Override
            public void run() {
                myClass.method2();
            }
        });

        Thread t3= new Thread(new Runnable() {
            @Override
            public void run() {
                myClass.method3();
            }
        });

        Thread t4= new Thread(new Runnable() {
            @Override
            public void run() {
                MyClass.method4();
            }
        });
        Thread t8= new Thread(new Runnable() {
            @Override
            public void run() {
                MyClass.method4();
            }
        });

        Thread t5= new Thread(new Runnable() {
            @Override
            public void run() {
                myClass.method4();
            }
        });
        Thread t9= new Thread(new Runnable() {
            @Override
            public void run() {
                myClass.method4();
            }
        });

        Thread t6= new Thread(new Runnable() {
            @Override
            public void run() {
                myClass.method5();
            }
        });
        Thread t10= new Thread(new Runnable() {
            @Override
            public void run() {
                myClass.method5();
            }
        });
        Thread t7= new Thread(new Runnable() {
            @Override
            public void run() {
                myClass.method6();
            }
        });
        Thread t11= new Thread(new Runnable() {
            @Override
            public void run() {
                myClass.method6();
            }
        });


        t8.start();
        //t2.start();
        t10.start();
    }
}
