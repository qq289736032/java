package com.jisen.ThreadPool;

import java.util.concurrent.*;

/**
 * @Desc TODO
 * @Author Administrator
 * @Date 2018/12/26 9:11
 */
public class CreateTest {
    public void print(){
        for (int i=0;i<5;i++){
            System.out.println(Thread.currentThread().getName()+":"+i);

        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                /**
                 * corePoolSize
                 * 核心线程池的大小,在创建了线程池后默认情况下线程池中并没有任何线程,而是等待有任务到来才创建线程去执行任务
                 * 除非threadPoolExecutor.prestartAllCoreThreads(),threadPoolExecutor.prestartCoreThread()调用这两个方法预创建线程
                 * 当线程池中的线程数目达到corePoolSize后就会把到达的任务放到缓存队列当中
                 */
                5,  //
                /**
                 * maximumPoolSize,表示在线程中最多能创建的线程数
                 */
                5,
                /**
                 * 当线程数量大于核心数量时,终止多余空闲线程等待任务的最长时间
                 * 但是如果调用了threadPoolExecutor.allowCoreThreadTimeOut(true);即使线程小于核心线程数,如果空闲时间超过这个时间也会被关闭
                 */
                3000,
                /**
                 * 时间单位
                 */
                TimeUnit.MILLISECONDS,  //线程保持时间的单位,毫秒
                /**
                 * 任务容器,线程池的派对策略与blockingqueue有关
                 */
                new ArrayBlockingQueue<>(4),
                /**
                 * 线程工厂
                 */
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return null;
                    }
                },
                /**
                 *  拒绝策略,如果当前线程池中的线程数目超过最大值,则会采取拒绝策略进行处理
                 * 1,丢弃任务并抛出异常
                 * 2,丢弃任务不抛出异常
                 * 3,丢弃最前面的任务,尝试执行新任务
                 * 4,由调用线程处理该任务
                 */
                new ThreadPoolExecutor.DiscardPolicy());    //当

        threadPoolExecutor.prestartCoreThread();
        threadPoolExecutor.prestartAllCoreThreads();
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });


    }
}
