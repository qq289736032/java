package com.jisen.IO.伪异步IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by jisen on 2018/2/26.
 */
public class TimeServerHandlerExecutePool {
    private ExecutorService executor;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        /**
         corePoolSize - 池中所保存的线程数，包括空闲线程。
         maximumPoolSize - 池中允许的最大线程数。
         keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
         unit - keepAliveTime 参数的时间单位。
         workQueue - 执行前用于保持任务的队列。此队列仅保持由 execute 方法提交的 Runnable 任务。
         */
        executor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void eexcute(Runnable task){
        executor.execute(task);
    }
}
