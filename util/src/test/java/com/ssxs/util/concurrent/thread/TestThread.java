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
public class TestThread extends Thread {

	private int a = 0;

	private int b = 0;

	/**
	 * 当对访问共享资源的方法不同时使用synchronized关键字时，是什么样一种情况呢？<br>
	 * 这是需要特别注意的，这样不能保证线程安全！<br>
	 *
	 * @param args
	 * @version V1.0.0
	 * @author Haixiang Dai <br>
	 *         createTime: 2012-5-2 上午9:02:52
	 */
	public static void main(String[] args) {
		TestThread test = new TestThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(test, "thread-" + i);
			thread.start();
		}
	}

	public synchronized void doWrite() {
		a++;
		try {
			sleep((int) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		b++;
		try {
			sleep((int) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
	}

	public void print() {
		System.out.println("" + Thread.currentThread().getName() + ":a:" + a);
		System.out.println("" + Thread.currentThread().getName() + ":b:" + b);
	}

	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			doWrite();
			print();
		}
	}

	public synchronized void start() {
		super.start();
	}

}
