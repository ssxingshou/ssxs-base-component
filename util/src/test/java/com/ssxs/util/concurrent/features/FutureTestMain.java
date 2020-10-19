/**
 *
 */
package com.ssxs.util.concurrent.features;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:03
 * modifyTime:
 * modifyBy:
 */
public class FutureTestMain {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

			}

		});
		System.out.println("start");
		Future<Object> future = executorService.submit(new Callable<Object>() {

			@Override
			public Object call() throws Exception {
				System.out.println("1");
				System.out.println("2");
				System.out.println("3");
				System.out.println("4");
				Thread.sleep(100000);
				return null;
			}
		});
		future.get(100000, TimeUnit.SECONDS);
		System.out.println("end");

	}

}
