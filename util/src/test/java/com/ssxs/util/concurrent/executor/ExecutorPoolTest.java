/**
 *
 */
package com.ssxs.util.concurrent.executor;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * <code>
 * ThreadPoolExecutor
 * <p>
 * public ThreadPoolExecutor(int corePoolSize,
 * int maximumPoolSize,
 * long keepAliveTime,
 * TimeUnit unit,
 * BlockingQueue<Runnable> workQueue)
 * <p>
 * 用给定的初始参数和默认的线程工厂及处理程序创建新的 ThreadPoolExecutor。使用 Executors 工厂方法之一比使用此通用构造方法方便得多。
 * <p>
 * 参数：
 * corePoolSize - 池中所保存的线程数，包括空闲线程。
 * maximumPoolSize - 池中允许的最大线程数。
 * keepAliveTime - 当线程数大于核心时，此为终止前多余的空闲线程等待新任务的最长时间。
 * unit - keepAliveTime 参数的时间单位。
 * workQueue - 执行前用于保持任务的队列。此队列仅保持由 execute 方法提交的 Runnable 任务。
 * 抛出：
 * IllegalArgumentException - 如果 corePoolSize 或 keepAliveTime 小于零，或者 maximumPoolSize 小于或等于零，或者 corePoolSize 大于 maximumPoolSize。
 * NullPointerException - 如果 workQueue 为 null
 * </code>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:03
 * modifyTime:
 * modifyBy:
 */
public class ExecutorPoolTest {

    @Test
    public void testPoolOne() {
        // 创建一个可重用固定线程数的线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。
        // ExecutorService pool = Executors.newCachedThreadPool();
        // 创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
        // ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);
        // 创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
        // ScheduledExecutorService pool =
        // Executors.newSingleThreadScheduledExecutor();

        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        // 使用延迟执行风格的方法
        // pool.schedule(t4, 10, TimeUnit.MILLISECONDS);
        // pool.schedule(t5, 10, TimeUnit.MILLISECONDS);

        pool.execute(t4);
        pool.execute(t5);
        // 关闭线程池
        // pool.shutdown();
        System.out.println("say hello!");
    }

    @Test
    public void testPoolTwo() {
        // 创建等待队列
        BlockingQueue<Runnable> bqueue = new ArrayBlockingQueue<Runnable>(20);
        // 创建一个单线程执行程序，它可安排在给定延迟后运行命令或者定期地执行。
        ThreadPoolExecutor pool = new ThreadPoolExecutor(2, 3, 2, TimeUnit.MILLISECONDS, bqueue);
        // 创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
        Thread t6 = new MyThread();
        Thread t7 = new MyThread();
        // 将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
        pool.execute(t4);
        pool.execute(t5);
        pool.execute(t6);
        pool.execute(t7);
        // 关闭线程池
        // pool.shutdown();
    }
}

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:03
 * modifyTime:
 * modifyBy:
 */
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }
}
