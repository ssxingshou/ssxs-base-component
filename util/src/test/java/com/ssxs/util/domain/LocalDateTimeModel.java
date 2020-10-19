package com.ssxs.util.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:05
 * modifyTime:
 * modifyBy:
 */
public class LocalDateTimeModel implements Serializable {
    private static final long serialVersionUID = -8726894270241532357L;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDateTime;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDateTime;

    public LocalDateTimeModel() {
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

}
