/**
 *
 */
package com.ssxs.util.concurrent.task;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public class ReadWriteLockTest {

	/**
	 * 锁嵌套导致死锁
	 *
	 * @param args
	 * @version V1.0.0
	 * @author Haixiang Dai <br>
	 *         createTime: 2012-7-11 上午11:01:20
	 */
	public static void main(String[] args) {
		ReadWriteLock rwLock = new ReentrantReadWriteLock();
		Lock readLock = rwLock.readLock();
		Lock writeLock = rwLock.writeLock();

		readLock.lock();
		writeLock.lock();
		writeLock.unlock();
		readLock.unlock();
		System.out.println("ok");
	}

}
