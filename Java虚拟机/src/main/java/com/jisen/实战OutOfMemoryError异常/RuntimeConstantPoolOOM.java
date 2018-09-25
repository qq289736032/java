package com.jisen.实战OutOfMemoryError异常;

/**
 * Created by jisen on 2018/6/14.
 */
//jdk1.7及以上就不会出现异常的结果
public class RuntimeConstantPoolOOM {
//    public static void main(String[] args) {
//        //使用List保持着常量池引用,避免FullGC回收常量池行为
//        List<String> list = new ArrayList<String>();
//        //10MB的PermSize在Integer范围内足够产生OOM
//        int i= 0;
//        while(true){
//            list.add(String.valueOf(i++).intern());
//        }
//
//    }


    public static void main(String[] args) {
        String str = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str.intern()==str);

        String str2 = new StringBuilder("Ja").append("va").toString();
        System.out.println(str2.intern()==str2);
    }

}
