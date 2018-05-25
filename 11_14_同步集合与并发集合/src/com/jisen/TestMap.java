package com.jisen;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jisen on 2018/4/12.
 */

/**
 * 1,每一个键值对叫做Entry
 * 2,hashmap是一个数组,数组装的是Entry,因此hashmap数组初始容量里没有元素,初始值都是null
 * 3,
 */

/**
 * 被transient修饰的字段这个字段的生命周期仅存于调用者的内存中而不会写到磁盘里持久化(不会被序列化)。
 * 一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
 * transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
 * 被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 */
public class TestMap {
    public static void main(String[] args) {
        Map hashmap = new HashMap();

        hashmap.put("1",1);
        hashmap.get("1");
        hashmap.putAll(hashmap);
    }
}
