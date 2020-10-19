/**
 *
 */
package com.ssxs.util.concurrent.task;

import java.util.List;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public class StressResult {
	private int concurrencyLevel;// 并发线程数
	private int totalTasks;// 总任务次数

	private long testsTakenTime;// 总耗时
	private int failedTasks;// 失败任务次数

	private List<Long> allTimes;// 每次请求的耗时

	private List<StressThreadWorker> workers;

	public long getTestsTakenTime() {
		return testsTakenTime;
	}

	public int getConcurrencyLevel() {
		return concurrencyLevel;
	}

	public void setConcurrencyLevel(int concurrencyLevel) {
		this.concurrencyLevel = concurrencyLevel;
	}

	public int getTotalTasks() {
		return totalTasks;
	}

	public void setTotalTasks(int totalTasks) {
		this.totalTasks = totalTasks;
	}

	public void setTestsTakenTime(long testsTakenTime) {
		this.testsTakenTime = testsTakenTime;
	}

	public int getFailedTasks() {
		return failedTasks;
	}

	public void setFailedTasks(int failedTasks) {
		this.failedTasks = failedTasks;
	}

	public List<Long> getAllTimes() {
		return allTimes;
	}

	public void setAllTimes(List<Long> allTimes) {
		this.allTimes = allTimes;
	}

	public List<StressThreadWorker> getWorkers() {
		return workers;
	}

	public void setWorkers(List<StressThreadWorker> workers) {
		this.workers = workers;
	}

}
