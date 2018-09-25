package com.jisen.TestGC;

/**
 * Created by jisen on 2018/2/24.
 */
public class TestGC {
    public Object instance = null;
    private static final int _1MB = 1024*1024;
    private byte[] bigSize = new byte[2*_1MB];
    public static void main(String[] args) {
        TestGC objA = new TestGC();
        TestGC objB = new TestGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }
}
