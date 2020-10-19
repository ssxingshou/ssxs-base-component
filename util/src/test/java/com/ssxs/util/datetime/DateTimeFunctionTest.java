package com.ssxs.util.datetime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Year;
import java.time.temporal.TemporalAdjusters;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2020-07-29 22:53
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class DateTimeFunctionTest {

    @Test
    public void testFunction() {
        LocalDateTime now = LocalDateTime.now();
        log.info("当前时间：" + now);
        // 第一天
        LocalDateTime firstDay = now.withDayOfMonth(1);
        log.info("本月第一天：" + firstDay);
        // 当天最后一秒
        LocalDateTime lastSecondOfDay = now.withHour(23).withMinute(59).withSecond(59);
        log.info("当天最后一秒：" + lastSecondOfDay);
        // 最后一天
        LocalDateTime lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        log.info("本月最后一天:" + lastDay);
        // 是否闰年
        log.info("今年是否闰年：" + Year.isLeap(now.getYear()));
    }

}
