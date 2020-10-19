/**
 *
 */
package com.ssxs.util.concurrent.task;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public class StressContext {

    // 每个线程的测试次数
    private int everyThreadCount;
    private CyclicBarrier threadStartBarrier;// 线程同步开始任务
    private CountDownLatch threadEndLatch;// 线程任务结束计数
    private AtomicInteger failedCounter; // 失败次数统计

    private StressTask stressTask;

    public int getEveryThreadCount() {
            return everyThreadCount;
    }

    public void setEveryThreadCount(int everyThreadCount) {
            this.everyThreadCount = everyThreadCount;
    }

    public CyclicBarrier getThreadStartBarrier() {
            return threadStartBarrier;
    }

    public void setThreadStartBarrier(CyclicBarrier threadStartBarrier) {
            this.threadStartBarrier = threadStartBarrier;
    }

    public CountDownLatch getThreadEndLatch() {
            return threadEndLatch;
    }

    public void setThreadEndLatch(CountDownLatch threadEndLatch) {
            this.threadEndLatch = threadEndLatch;
    }

    public AtomicInteger getFailedCounter() {
            return failedCounter;
    }

    public void setFailedCounter(AtomicInteger failedCounter) {
            this.failedCounter = failedCounter;
    }

    public StressTask getTestService() {
            return stressTask;
    }

    public void setTestService(StressTask stressTask) {
            this.stressTask = stressTask;
    }

}
