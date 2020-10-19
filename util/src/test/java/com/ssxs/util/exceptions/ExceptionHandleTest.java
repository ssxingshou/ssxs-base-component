/**
 *
 */
package com.ssxs.util.exceptions;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:04
 * modifyTime:
 * modifyBy:
 */
public class ExceptionHandleTest {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    /**
     * 模拟出现异常时的处理：
     * <p>
     * 1、try{}catch{}了异常后，会如何？
     */
    @Test
    public void testExceptionHandle() {
        String[] arr = new String[2];
        try {
            arr[0] = "0";
            arr[1] = "1";
            arr[2] = "2";
        } catch (Exception e) {
            LOGGER.error("err:{}", e.getMessage(), e);
        }
        LOGGER.info("come here");

    }

}
