package com.ssxs.util.json;

import com.ssxs.util.domain.UserModel;
import com.ssxs.util.jackson.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2020-07-03 10:01
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class JacksonTest {

    /**
     * 暂未安排切换jackson的过程
     */
    @Test
    public void testObjToString() {
        UserModel userModel = new UserModel();
        userModel.setAccount("hello");
        userModel.setCreatedTime(LocalDateTime.now());
        String str = JacksonUtil.obj2String(userModel);
        log.info(str);
    }

}
