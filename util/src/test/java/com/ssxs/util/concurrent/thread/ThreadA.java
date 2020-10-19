/**
 *
 */
package com.ssxs.util.concurrent.thread;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public class ThreadA extends Thread {

	public int total;

	@Override
	public void run() {
		synchronized (this) {
			// 唤醒主线程
			System.out.println("ThreadB is running..");
			for (int i = 0; i < 100; i++) {
				total += i;
				System.out.println("total is " + total);
			}
			// 只有在一个notify()或notifyAll()发生变化的时候，线程才会被唤醒
			// 只能在同步方法或者同步块里面调用wait()和notify().
			notify();
		}
	}

}
