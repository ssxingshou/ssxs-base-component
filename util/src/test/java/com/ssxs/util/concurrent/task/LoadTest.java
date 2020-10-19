/**
 *
 */
package com.ssxs.util.concurrent.task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
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
public class LoadTest {
	static int concurrencyLevel = 100;
	static int totalRequests = 100000;

	public static void main(String[] args) {

		StressTask task = new StressTask() {
			@Override
			public Object doTask() throws Exception {
				for (int i = 0; i < 1000; i++) {
					// synchronizedMap();
					writeLock();
					// readLock();
					// concurrentHashMap();
					// volatileMap();
					// justDoGet();
				}
				return null;
			}
		};

		StressTestUtils.testAndPrint(concurrencyLevel, totalRequests, task);
	}

	static Map<String, String> map = new HashMap<String, String>();
	static volatile Map<String, String> volatileMap = new HashMap<String, String>();
	static Map<String, String> concurrentHashMap = new ConcurrentHashMap<String, String>();
	static {
		map.put("name", "andy");
		map.put("age", "26");
		volatileMap.put("name", "andy");
		volatileMap.put("age", "26");
		concurrentHashMap.put("name", "andy");
		concurrentHashMap.put("age", "26");
	}

	static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	static Lock readLock = readWriteLock.readLock();
	static Lock writeLock = readWriteLock.writeLock();

	@SuppressWarnings("unused")
	static void readLock() {
		String name = null;
		readLock.lock();
		try {
			name = map.get("name");
		} finally {
			readLock.unlock();
		}
	}

	@SuppressWarnings("unused")
	static void writeLock() {
		String name = null;
		writeLock.lock();
		try {
			name = map.get("name");
		} finally {
			writeLock.unlock();
		}
	}

	@SuppressWarnings("unused")
	static void justDoGet() {
		String name = null;
		name = map.get("name");
	}

	@SuppressWarnings("unused")
	static void volatileMap() {
		String name = null;
		name = volatileMap.get("name");
	}

	@SuppressWarnings("unused")
	static void concurrentHashMap() {
		String name = null;
		name = concurrentHashMap.get("name");
	}

	@SuppressWarnings("unused")
	static synchronized void synchronizedMap() {
		String name = null;
		name = map.get("name");
	}

}
