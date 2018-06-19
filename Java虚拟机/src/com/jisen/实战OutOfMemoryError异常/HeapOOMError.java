package com.jisen.实战OutOfMemoryError异常;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jisen on 2018/6/14.
 */

//java堆异常,是实际应用中常见的内存溢出异常
//    要解决这个区域的异常,一般手段是先通过内存映像分析工具对Dump出来的堆转存储快照进行分析,终点是确认内存中的对象是否有必要,也就是先确认到底是内存溢出还是内存泄露
public class HeapOOMError {
    static class OOMObject{}

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
