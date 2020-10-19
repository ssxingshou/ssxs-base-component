/**
 *
 */
package com.ssxs.util.concurrent.task;

import java.io.StringWriter;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public class StressTestUtils {
	private static StressTester stressTester = new StressTester();
	private static SimpleResultFormater simpleResultFormater = new SimpleResultFormater();

	public static StressResult test(int concurrencyLevel, int totalTasks, StressTask stressTask) {
		return stressTester.test(concurrencyLevel, totalTasks, stressTask);
	}

	public static StressResult test(int concurrencyLevel, int totalTasks, StressTask stressTask, int warmUpTime) {
		return stressTester.test(concurrencyLevel, totalTasks, stressTask, warmUpTime);
	}

	public static void testAndPrint(int concurrencyLevel, int totalTasks, StressTask stressTask) {
		testAndPrint(concurrencyLevel, totalTasks, stressTask, null);
	}

	public static void testAndPrint(int concurrencyLevel, int totalTasks, StressTask stressTask, String testName) {
		StressResult stressResult = test(concurrencyLevel, totalTasks, stressTask);
		String str = format(stressResult);
		System.out.println(str);
	}

	public static void testAndPrint(int concurrencyLevel, int totalTasks, StressTask stressTask, int warmUpTime, String testName) {
		StressResult stressResult = test(concurrencyLevel, totalTasks, stressTask, warmUpTime);
		String str = format(stressResult);
		System.out.println(str);
	}

	public static String format(StressResult stressResult) {
		return format(stressResult, simpleResultFormater);
	}

	public static String format(StressResult stressResult, StressResultFormater stressResultFormater) {
		StringWriter sw = new StringWriter();
		stressResultFormater.format(stressResult, sw);
		return sw.toString();
	}

}
