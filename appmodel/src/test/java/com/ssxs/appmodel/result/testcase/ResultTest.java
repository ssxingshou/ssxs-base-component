package com.ssxs.appmodel.result.testcase;

import com.ssxs.appmodel.domain.result.ModelResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:08
 * modifyTime:
 * modifyBy:
 */
public class ResultTest {
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Test
    public void test() {
        ModelResult<String> modelResult = new ModelResult<>();
        modelResult.withModelFromCache("cache");

        LOGGER.info("modelResult:{}", modelResult);
    }

}
