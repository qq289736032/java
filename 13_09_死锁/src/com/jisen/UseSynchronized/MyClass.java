package com.jisen.UseSynchronized;

/**
 * @Desc TODO
 * @Author Administrator
 * @Date 2018/12/25 10:24
 */
public class MyClass {
    public synchronized void method1() {
        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName()+"-method1:"+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void method2(){
        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName()+"-method2:"+i);
        }
    }

    public void method3(){
        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName()+"-method3:"+i);
        }
    }
    public static synchronized void method4(){
        for(int i=0; i<5; i++){
            System.out.println(Thread.currentThread().getName()+"-method4:"+i);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
    public void method5(){
        synchronized (MyClass.class){
            for(int i=0; i<5; i++){
                System.out.println(Thread.currentThread().getName()+"-method5:"+i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void method6(){
        System.out.println("method6before");
        synchronized (this){
            for(int i=0; i<5; i++){
                System.out.println(Thread.currentThread().getName()+"-method6:"+i);
            }
        }
    }
}
