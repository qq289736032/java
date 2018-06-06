package 面试题2_实现Singleton;

/**
 * Created by jisen on 2018/6/5.
 */


public class Singleton5 {

    private static class SingletonHolder {
        private static Singleton5 singleton = new Singleton5();
    }

    private Singleton5() {
    }

    public static Singleton5 newInstance() {
        return SingletonHolder.singleton;
    }
    //这里创建了一个内部静态类，通过内部类的机制使得单例对象可以延迟加载，
    // 同时内部类相当于是外部类的静态部分，所以可以通过jvm来保证其线程安全。这种形式比较推荐。
}
