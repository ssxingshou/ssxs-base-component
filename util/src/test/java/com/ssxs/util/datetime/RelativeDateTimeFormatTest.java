package com.ssxs.util.datetime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2020-04-09 16:38
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class RelativeDateTimeFormatTest {

    @Test
    public void testRelativeDateTimeFormat() {
        LocalDateTime dateTime = LocalDateTime.now();
        dateTime = dateTime.minusDays(2);
        log.info("转化后的时间输出：{}", RelativeDateTimeFormat.format(dateTime));
    }

}
