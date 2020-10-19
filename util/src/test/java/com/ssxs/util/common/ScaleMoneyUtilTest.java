package com.ssxs.util.common;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2020-04-17 10:07
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class ScaleMoneyUtilTest {

    @Test
    public void testInt2wStr() {
        String wStr = ScaleMoneyUtil.int2wStr(10000);
        log.info("wStr={}", wStr);
    }

}
