package 面试题2_实现Singleton;

/**
 * Created by jisen on 2018/6/5.
 */

//懒汉式
public class Singleton2 {

    private static Singleton2 instance ;

    //构造函数私有
    private Singleton2(){}

    public static synchronized Singleton2  getInstance() {
        if(instance == null){
            instance = new Singleton2();
        }
        return instance;
    }
    //可以避免单线程问题但是会影响性能
}
