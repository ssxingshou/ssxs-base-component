package com.ssxs.util.datetime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2017
 * createTime: 2017/4/13 11:39
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class DateTimeUtilTest {

    @Test
    public void testIsEquals() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime cur = DateTimeUtil.buildStringToLocalDateTime("2017-03-29 16:39:10");

        boolean isCorrect = now.isEqual(cur);
        log.info("{}", isCorrect);
    }

    @Test
    public void testLong() {
        LocalDateTime myTime = DateTimeUtil.buildLongToLocalDateTime(1505825061);
        log.info("myTime:{}", DateTimeUtil.buildLocalDateTimeToString(myTime));

        LocalDateTime now = LocalDateTime.now();
        //now.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long nowLong = now.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        log.info("nowLong:{}", nowLong);
    }

}
