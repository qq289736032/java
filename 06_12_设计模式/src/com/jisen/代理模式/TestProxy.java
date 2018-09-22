package com.jisen.代理模式;

/**
 * Created by jisen on 2018/8/30.
 */
public class TestProxy {
    public static void main(String[] args) {
        ProxyInterface proxyInterface = new WeddingCompany(new NewMan());
        proxyInterface.marry();
    }
}
