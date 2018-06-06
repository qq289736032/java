package 面试题2_实现Singleton;

/**
 * Created by jisen on 2018/6/5.
 */

/**
 * 只适用于单线程
 */

//懒汉式
public class Singleton1 {

    private static Singleton1 instance = null;

    //构造函数私有
    private Singleton1(){}

    public static Singleton1 getInstance() {
        if(instance == null){
            instance = new Singleton1();
        }
        return instance;
    }

    //如果两个线程同时判断instance是否为null的if语句并且instance没有创建是都会创建一个实例
}
