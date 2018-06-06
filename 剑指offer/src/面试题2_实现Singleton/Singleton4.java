package 面试题2_实现Singleton;

/**
 * Created by jisen on 2018/6/5.
 */



//懒汉式加强版
public class Singleton4 {

    private volatile static Singleton4 singleton;

    private Singleton4() {
    }

    public static Singleton4 newInstance() {
        if (singleton == null) {
            synchronized (Singleton4.class) {
                if (singleton == null) {
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }
    //这个是懒汉形式的加强版，将synchronized关键字移到了newInstance方法里面，同时将singleton对象加上volatile关键字，
    // 这种方式既可以避免多线程问题，又不会降低程序的性能。但volatile关键字也有一些性能问题，不建议大量使用
}
