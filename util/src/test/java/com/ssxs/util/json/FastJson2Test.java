package com.ssxs.util.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:04
 * modifyTime:
 * modifyBy:
 */
public class FastJson2Test {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Test
    public void test() {
        Long[] itemIds = new Long[]{1L, 2L, 3L, 4L};
        String itemIdsStr = JSON.toJSONString(itemIds, SerializerFeature.UseISO8601DateFormat);
        LOGGER.info("itemIdsStr={}", itemIdsStr);
        List<Long> listString = JSON.parseArray(itemIdsStr, Long.class);
        LOGGER.info("listString={}", listString);

        JSONArray jsonArray = new JSONArray();
        LOGGER.info("jsonArray={}", jsonArray);

    }

}
