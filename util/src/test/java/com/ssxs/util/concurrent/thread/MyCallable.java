/**
 *
 */
package com.ssxs.util.concurrent.thread;

import java.util.concurrent.Callable;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public class MyCallable implements Callable<Object> {

	private String oid;

	public MyCallable(String oid) {
		this.oid = oid;
	}

	@Override
	public Object call() throws Exception {
		// 执行任务，然后返回结果
		return oid + "任务返回的内容";
	}

}
