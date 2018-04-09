package com.jisen.对象成员变量的线程安全;

/**
 * 这个方法是线程不安全的
 * Created by jisen on 2018/1/11.
 */
public class NotThreadSafe {
    StringBuilder builder = new StringBuilder();
    public StringBuilder add(String text){
        return this.builder.append(text);
    }
}
