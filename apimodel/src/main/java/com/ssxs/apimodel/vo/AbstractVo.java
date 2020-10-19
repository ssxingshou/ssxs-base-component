package com.ssxs.apimodel.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.Serializable;

/**
 * 统一使用此vo抽象类
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright:
 * createTime: 2016/11/22 17:52
 * modifyTime:
 * modifyBy:
 */
public abstract class AbstractVo implements Serializable {
    private static final long serialVersionUID = 7791414686504449277L;

    @Override
    public String toString() {
        return JSON.toJSONString(this, SerializerFeature.DisableCircularReferenceDetect);
    }

}
