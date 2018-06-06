package 面试题2_实现Singleton;

/**
 * Created by jisen on 2018/6/5.
 */


//饿汉式
public class Singleton3 {

    private static Singleton3 singleton= new Singleton3();

    private Singleton3() {
    }

    public static Singleton3 newInstance() {
        return singleton;
    }
    //可以避免单线程问题但是会影响性能,在单例对象声明的时候就直接初始化对象，
    // 可以避免多线程问题，但是如果对象初始化比较复杂，会导致程序初始化缓慢。
}
