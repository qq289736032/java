package com.jisen;

import java.io.Serializable;

/**
 * Created by jisen on 2018/4/11.
 */


/**
 * 悲观锁:总是假设最坏的情况,每次去拿数据的时候都认为会被人修改,所以每次拿数据的时候都上锁,java中的synchronized是悲观锁
 * 悲观锁存在以下几个问题:
 *  1,在多线程竞争下,加锁,释放锁会导致比较多的上下文切换和调度延时
 *  2, 如果一个线程持有锁会导致其他所有需要此锁的线程挂起
 *  3, 如果一个优先级高的线程等待一个优先级低的线程释放锁会导致优先级倒置引起性能风险
 */

/**
 * 乐观锁:只有在数据提交时,才会正式对数据是否产生并发冲突进行检测,冲突检测和数据更新
 */

/**
 * ABA问题:
 */
public class AtomicInteger extends Number implements Serializable {

    private volatile int value;
    public final int get(){
        return value;
    }
    public final int getAndIncrement(){
        for(;;){
            int current = get();
            int next = current+1;
            if(compareAndSet(current,next))
                return current;
        }
    }
    public final boolean compareAndSet(int expect, int update){
        return /*compareAandSwapInt(this,valueOffset,expect,update);*/true;
    }
    @Override
    public int intValue() {
        return 0;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        return 0;
    }
}
