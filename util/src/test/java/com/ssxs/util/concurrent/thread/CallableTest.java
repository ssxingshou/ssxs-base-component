/**
 *
 */
package com.ssxs.util.concurrent.thread;

import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public class CallableTest {

	/**
	 *
	 * @throws Exception
	 */
	@Test
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void testMyCallable() throws Exception {
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(2);
		// 创建两个有返回值的任务

		Callable c1 = new MyCallable("A");
		Callable c2 = new MyCallable("B");
		// 执行任务并获取Future对象
		Future f1 = pool.submit(c1);
		Future f2 = pool.submit(c2);
		// 从Future对象上获取任务的返回值，并输出到控制台
		System.out.println(">>>" + f1.get().toString());
		System.out.println(">>>" + f2.get().toString());
		// 关闭线程池
		pool.shutdown();
	}

}
