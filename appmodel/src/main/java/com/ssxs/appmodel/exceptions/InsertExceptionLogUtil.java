/**
 *
 */
package com.ssxs.appmodel.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 插入异常日志打印与抛出异常到下一级
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/9/6 23:00
 * modifyTime:
 * modifyBy:
 */
public abstract class InsertExceptionLogUtil {
    private final static Logger LOGGER = LoggerFactory.getLogger(InsertExceptionLogUtil.class);

    /**
     *
     * @param affectedCount
     */
    public static void showInsertExceptionLog(int affectedCount) {
        if (affectedCount != 1) {
            String msg = "{msg:'插入记录有问题',affectedCount:" + affectedCount + ",errorSource:'sql'}";
            LOGGER.error(msg);
            throw new RuntimeException(msg);
        }
    }
}
