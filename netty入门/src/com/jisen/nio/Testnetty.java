package com.jisen.nio;

/**
 * Created by jisen on 2018/1/29.
 *
 */
public class Testnetty {
    /**
     * NIO即new io
     * 普通的IO是面向流,阻塞IO,
     * NIO是面向缓冲,非阻塞IO
     * Java IO面向流意味着每次从流中读取一个或者多个字节,直至读取所有字节,他们没有被缓存在任何地方,.此外它不能移动流中的数据.如果需要前后移动从流中读取的数据,需要先将它缓存到一个缓冲区
     * Java NIO的缓冲导向方法略有不同.数据读取到一个它稍后处理的缓冲区中前后移动,这就增加了处理过程中的灵活性,但是还需要检查是否该缓冲区中包含所有您需要处理的数据,
     * 而且需要确保更多的数据读入缓冲区时,不要覆盖缓冲区里尚未处理的数据.
     *
     * @param args
     */
    public static void main(String[] args) {

    }
}
