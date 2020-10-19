package com.ssxs.util.random;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2017/11/2 11:07
 * modifyTime:
 * modifyBy:
 */
public class RandomNumUtilTest {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Test
    public void testRandomNumUtil() {
        LOGGER.info("RandomInt:{}", RandomNumUtil.getRandomInt(4));
    }

}
