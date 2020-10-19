/**
 *
 */
package com.ssxs.util.concurrent.executor;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:04
 * modifyTime:
 * modifyBy:
 */
public class ExecutorServiceTest {

	@Test
	public void test1() throws InterruptedException, ExecutionException, TimeoutException {
		// 创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
		ExecutorService executor = Executors.newSingleThreadExecutor();

		Callable<Object> task = new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				Object result = "...";
				return result;
			}
		};

		Future<Object> future = executor.submit(task);
		future.get(); // 等待至完成

		future.get(3, TimeUnit.SECONDS); // 等待3s，超时后会抛出TimeoutException

	}

}
