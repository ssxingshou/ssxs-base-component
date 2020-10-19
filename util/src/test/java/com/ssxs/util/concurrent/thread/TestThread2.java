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
public class TestThread2 extends Thread {

	private int a = 0; // 独立的共享资源

	private int b = 0; // b、c互相依赖

	private int c = 0;

	private volatile long d = 0L; // 64位

	// private SomeObj obj = new SomeObj(); //对象类型，大家自己写吧，我就不写了。

	/**
	 * ThreadLocal对于线程安全还是很有用的，如果资源不是共享的，那么应该使用ThreadLocal，<br>
	 * 但如果确实需要在线程间共享资源，ThreadLocal就没有用了！<br>
	 *
	 * @param args
	 * @version V1.0.0
	 * @author Haixiang Dai <br>
	 *         createTime: 2012-5-2 上午9:07:31
	 */
	public static void main(String[] args) {
		TestThread test = new TestThread();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(test, "thread-" + i);
			thread.start();
		}
	}

	public synchronized void doWrite() {
		b++;
		try {
			sleep((int) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
		c++;
		try {
			sleep((int) (Math.random() * 100));
		} catch (InterruptedException e) {
		}
	}

	public synchronized void print() {
		System.out.println("" + Thread.currentThread().getName() + ":b:" + b);
		System.out.println("" + Thread.currentThread().getName() + ":c:" + c);
	}

	private void setA(int a) {
		this.a = a;
	}

	private int getA() {
		return a;
	}

	public long getD() {
		return d;
	}

	public void setD(long d) {
		this.d = d;
	}

	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			doWrite();
			print();
			setA(i);
			System.out.println(getA());
			setD(18456187413L * i);
			System.out.println(getD());
		}
	}

	public synchronized void start() {
		super.start();
	}

}
