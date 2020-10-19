/**
 *
 */
package com.ssxs.util.concurrent.locks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:02
 * modifyTime:
 * modifyBy:
 */
public class ConcurrentTest {

	public static ExecutorService executor = Executors.newCachedThreadPool();

	public static Map<Object, Object> map = null;

	public static int count = 1000;
	static {
		map = new HashMap<Object, Object>();
		map = new ConcurrentHashMap<Object, Object>();
		for (int i = 0; i < count; i++) {
			map.put(i, i);
		}
	}

	public static void main(String[] args) {
		executor.execute(new IteratorThread());
		executor.execute(new RemoveThread());
		executor.shutdown();
	}

	static class IteratorThread implements Runnable {

		@Override
		public void run() {
			try {
				doWork();
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		public void doWork() {
			Iterator<Entry<Object, Object>> iterator = map.entrySet().iterator();

			while (iterator.hasNext()) {
				try {
					Entry<Object, Object> entry = iterator.next();
					System.out.println(entry);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			System.out.println("iterator size:" + map.size());
		}
	}

	static class RemoveThread implements Runnable {

		@Override
		public void run() {
			try {
				doWork();
			} catch (Throwable e) {

			}
		}

		public void doWork() {
			for (int i = 0; i < count; i++) {
				if (i % 2 == 0) {
					map.remove(i);
					System.out.println("remove:" + i);
				}
			}
			System.out.println("remove size:" + map.size());
		}
	}

}
