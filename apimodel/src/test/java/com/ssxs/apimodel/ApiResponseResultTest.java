package com.ssxs.apimodel;

import com.alibaba.fastjson.JSON;
import com.ssxs.apimodel.domain.ApiResponseData;
import com.ssxs.apimodel.domain.ApiResponseMeta;
import com.ssxs.apimodel.domain.ApiResponseResult;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:16
 * modifyTime:
 * modifyBy:
 */
public class ApiResponseResultTest {
    private Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Test
    public void testApiResponseResult() {
        ApiResponseMeta apiResponseMeta = new ApiResponseMeta();
        apiResponseMeta.setCode("999");
        apiResponseMeta.setMsg("sss");

        List<Long> idList = new ArrayList<>();
        idList.add(1L);
        idList.add(2L);

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("idList", idList);
        String jsonStr = JSON.toJSONString(resultMap);

        LOGGER.info("apiResponseResult:{}", new ApiResponseResult().success(
                ApiResponseData.create(jsonStr)));
    }

}
