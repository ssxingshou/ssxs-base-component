/**
 *
 */
package com.ssxs.util.datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * 使用 Duration.between(startTime, endTime).getSeconds() 去计算时间差
 * ChronoUnit.MILLIS.between
 * 获取当前时间的时间戳：Instant.now().toEpochMilli()
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright:
 * createTime:
 * modifyTime:
 * modifyBy:
 */
public final class DateTimeUtil {
    /** 标准的格式 */
    public static String STANDARD_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String TIME_PATTERN = "HH:mm:ss";

    /**
     * 转换dateTime到时间戳，通过zone8转换
     *
     * @param localDateTime
     * @return
     */
    public static long buildLocalDataTimeToTimestampZone8(LocalDateTime localDateTime) {
        long timestamp = localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
        return timestamp;
    }

    /**
     * 转换dateTime到时间戳，通过zone转换
     *
     * @param localDateTime
     * @return
     */
    public static long buildLocalDataTimeToTimestamp(LocalDateTime localDateTime) {
        long timestamp = localDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return timestamp;
    }

    /**
     * 转换long型时间戳的时间为LocalDateTime
     *
     * @param timestamp
     * @return
     */
    public static LocalDateTime buildLongToLocalDateTime(long timestamp) {
        Instant expiredTimeInstant = Instant.ofEpochMilli(timestamp);
        LocalDateTime currentLocalDateTime = LocalDateTime.ofInstant(expiredTimeInstant, ZoneId.systemDefault());
        return currentLocalDateTime;
    }

    /**
     * 返回销毁日期，暂时使用为2999年到期。
     *
     * @return
     */
    public static LocalDateTime buildAbolishTime() {
        return LocalDateTime.of(2999, 12, 31, 23, 59, 59);
    }

    /**
     * 把当前Date型时间转换成LocalDatetime类型的时间
     *
     * @param currentDate
     * @return
     */
    public static LocalDateTime buildDateToLocalDateTime(Date currentDate) {
        Instant expiredTimeInstant = Instant.ofEpochMilli(currentDate.getTime());
        LocalDateTime currentLocalDateTime = LocalDateTime.ofInstant(expiredTimeInstant, ZoneId.systemDefault());
        return currentLocalDateTime;
    }

    /**
     * 根据LocalDateTime转成String型日期。
     *
     * @param dateTime
     * @return
     */
    public static String buildLocalDateTimeToString_YYYYMMDDHHMMSS(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        String formatted = dateTime.format(dateFormatter);
        return formatted;
    }

    /**
     * 根据LocalDateTime转成String型日期。
     *
     * @param dateTime
     * @return
     */
    public static String buildLocalDateTimeToString_YYYYMMDDHHMMSSFFF(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmssfff");
        String formatted = dateTime.format(dateFormatter);
        return formatted;
    }

    /**
     * 根据LocalDateTime转成String型日期。
     *
     * @param dateTime
     * @return
     */
    public static String buildLocalDateTimeToString_YYMMDDHHMMSS(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String formatted = dateTime.format(dateFormatter);
        return formatted;
    }

    /**
     * 根据LocalDateTime转成String型日期。
     *
     * @param dateTime
     * @return
     */
    public static String buildLocalDateTimeToString_YYMMDDHHMMSSFFF(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyMMddHHmmssfff");
        String formatted = dateTime.format(dateFormatter);
        return formatted;
    }

    /**
     * 根据LocalDateTime转成String型日期。
     *
     * @param dateTime
     * @return
     */
    public static String buildLocalDateTimeToString_YYMMDDHHMM(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyMMddHHmm");
        String formatted = dateTime.format(dateFormatter);
        return formatted;
    }

    /**
     * 根据LocalDateTime转成String型日期。
     *
     * @param dateTime
     * @return
     */
    public static String buildLocalDateTimeToString_YYYYMMDDHHMM(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formatted = dateTime.format(dateFormatter);
        return formatted;
    }

    /**
     * 根据LocalDateTime转成String型日期。
     *
     * @param dateTime
     * @return
     */
    public static String buildLocalDateTimeToString_HHMM(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm");
        String formatted = dateTime.format(dateFormatter);
        return formatted;
    }

    /**
     * 根据LocalDateTime转成String型日期
     *
     * @param dateTime
     * @return
     */
    public static String buildLocalDateTimeToString_YYYYMMDD(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatted = dateTime.format(dateFormatter);
        return formatted;
    }

    /**
     * 根据LocalDateTime转成String型日期。
     *
     * @param dateTime
     * @return
     */
    public static String buildLocalDateTimeToString(LocalDateTime dateTime) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(STANDARD_PATTERN);
        String formatted = dateTime.format(dateFormatter);
        return formatted;
    }

    /**
     * 根据String型时间日期转成LocalDateTime
     *
     * @param dateTimeStr
     * @return
     */
    public static LocalDateTime buildStringToLocalDateTime(String dateTimeStr) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(STANDARD_PATTERN);
        TemporalAccessor temporalAccessor = dateFormatter.parse(dateTimeStr);
        LocalDateTime value = LocalDateTime.from(temporalAccessor);
        return value;
    }

    /**
     * 根据LocalDateTime转成20150613这种格式的String型日期。
     *
     * @param date
     * @return
     */
    public static String buildLocalDateToString_yyyyMMdd(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        String formatted = date.format(dateFormatter);
        return formatted;
    }

    /**
     * 转换Sting型日期为LocalDate格式为：yyyy-MM
     *
     * @param dateString
     * @return
     */
    public static LocalDate buildStringToLocalDate_yyyy_MM(String dateString) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        TemporalAccessor temporalAccessor = dateFormatter.parse(dateString);
        LocalDate value = LocalDate.from(temporalAccessor);
        return value;
    }

    /**
     * 转换Sting型日期为LocalDate格式为：yyyyMMdd
     *
     * @param dateString
     * @return
     */
    public static LocalDate buildStringToLocalDate_yyyyMMdd(String dateString) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        TemporalAccessor temporalAccessor = dateFormatter.parse(dateString);
        LocalDate value = LocalDate.from(temporalAccessor);
        return value;
    }

    /**
     * 转换Sting型日期为LocalDate
     *
     * @param dateString
     * @return
     */
    public static LocalDate buildStringToLocalDate(String dateString) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TemporalAccessor temporalAccessor = dateFormatter.parse(dateString);
        LocalDate value = LocalDate.from(temporalAccessor);
        return value;
    }

    /**
     * 转换LocalDate为String型日期
     *
     * @param date
     * @return
     */
    public static String buildLocalDateToString(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formatted = date.format(dateFormatter);
        return formatted;
    }

    /**
     * 转换LocalDate为String型日期
     *
     * @param date
     * @return
     */
    public static String buildLocalDateToString_yyyy_MM(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String formatted = date.format(dateFormatter);
        return formatted;
    }

    /**
     * 转换LocalDate为String型日期
     *
     * @param date
     * @return
     */
    public static String buildLocalDateToString_dd(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd");
        String formatted = date.format(dateFormatter);
        return formatted;
    }

    /**
     * 转换LocalDate为String型日期
     *
     * @param date
     * @return
     */
    public static String buildLocalDateToString_yyMM(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyMM");
        String formatted = date.format(dateFormatter);
        return formatted;
    }

    /**
     * 转换LocalDate为String型日期
     *
     * @param date
     * @return
     */
    public static String buildLocalDateToString_yyMMdd(LocalDate date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyMMdd");
        String formatted = date.format(dateFormatter);
        return formatted;
    }

}
