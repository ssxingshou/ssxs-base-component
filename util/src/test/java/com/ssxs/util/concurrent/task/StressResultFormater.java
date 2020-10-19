/**
 *
 */
package com.ssxs.util.concurrent.task;

import java.io.Writer;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:01
 * modifyTime:
 * modifyBy:
 */
public interface StressResultFormater {

	void format(StressResult stressResult, Writer writer);

}
