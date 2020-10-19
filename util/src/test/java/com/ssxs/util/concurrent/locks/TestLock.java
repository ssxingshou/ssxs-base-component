/**
 *
 */
package com.ssxs.util.concurrent.locks;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 在Java5中，专门提供了锁对象，利用锁可以方便的实现资源的封锁，用来控制对竞争资源并发访问的控制，这些内容主要集中在java.util.
 * concurrent.locks 包下面，里面有三个重要的接口Condition、Lock、ReadWriteLock。 Condition 将
 * Object 监视器方法（wait、notify 和 notifyAll）分解成截然不同的对象，以便通过将这些对象与任意 Lock
 * 实现组合使用，为每个对象提供多个等待 set （wait-set）。 Lock 实现提供了比使用 synchronized
 * 方法和语句可获得的更广泛的锁定操作。 ReadWriteLock 维护了一对相关的锁定，一个用于只读操作，另一个用于写入操作。
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:02
 * modifyTime:
 * modifyBy:
 */
public class TestLock {

    public static void main(String[] args) {
        // 创建并发访问的账户
        MyCount myCount = new MyCount("95599200901215522", 10000);
        // 创建一个锁对象
        ReadWriteLock lock = new ReentrantReadWriteLock(false);
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(2);
        // 创建一些并发访问用户，一个信用卡，存的存，取的取，好热闹啊
        UserObj u1 = new UserObj("张三", myCount, -4000, lock, false);
        UserObj u2 = new UserObj("张三他爹", myCount, 6000, lock, false);
        UserObj u3 = new UserObj("张三他弟", myCount, -8000, lock, false);
        UserObj u4 = new UserObj("张三", myCount, 800, lock, false);
        UserObj u5 = new UserObj("张三他爹", myCount, 0, lock, true);
        // 在线程池中执行各个用户的操作
        pool.execute(u1);
        pool.execute(u2);
        pool.execute(u3);
        pool.execute(u4);
        pool.execute(u5);
        // 关闭线程池
        pool.shutdown();
    }

}
