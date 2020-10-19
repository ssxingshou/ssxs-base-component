package com.ssxs.util.datetime;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2020-07-29 22:51
 * modifyTime:
 * modifyBy:
 */
@Slf4j
public class DateTimeUntilTest {

    @Test
    public void testUntil() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yestory = now.minusDays(1);
        log.info(now + "在" + yestory + "之后吗?" + now.isAfter(yestory));
        log.info(now + "在" + yestory + "之前吗?" + now.isBefore(yestory));

        // 时间差
        long day = yestory.until(now, ChronoUnit.DAYS);
        long month = yestory.until(now, ChronoUnit.MONTHS);
        long hours = yestory.until(now, ChronoUnit.HOURS);
        long minutes = yestory.until(now, ChronoUnit.MINUTES);
        log.info("相差月份" + month);
        log.info("相差天数" + day);
        log.info("相差小时" + hours);
        log.info("相差分钟" + minutes);

        // 距离JDK 14 发布还有多少天？
        LocalDate jdk14 = LocalDate.of(2020, 3, 17);
        LocalDate nowDate = LocalDate.now();
        log.info("距离JDK 14 发布还有：" + nowDate.until(jdk14, ChronoUnit.DAYS) + "天");
    }

}
