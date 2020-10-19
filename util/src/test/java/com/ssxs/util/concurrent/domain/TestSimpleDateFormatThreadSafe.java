/**
 *
 */
package com.ssxs.util.concurrent.domain;

import java.text.ParseException;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:05
 * modifyTime:
 * modifyBy:
 */
public class TestSimpleDateFormatThreadSafe extends Thread {

	public TestSimpleDateFormatThreadSafe(String name) {
		super(name);
	}

	@Override
	public void run() {
		while (true) {
			try {
				this.join(2000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			try {
				String dateStr = "2011-10-11 06:02:20";
				System.out.println(this.getName() + "_" + DateUtil.parse(dateStr));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20; i++)
			new TestSimpleDateFormatThreadSafe("thread:" + i).start();
	}

}
