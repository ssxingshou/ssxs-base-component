package com.ssxs.apimodel.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.ssxs.apimodel.vo.AbstractVo;

import java.util.Map;

/**
 * 请求要求规范为json格式
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2017/1/23 16:43
 * modifyTime:
 * modifyBy:
 */
public class ApiRequestData extends AbstractVo {
    private static final long serialVersionUID = 2536743187912110478L;
    /**
     * 属性
     */
    private Map<String, Object> attrs;
    /**
     * json数据
     */
    private String json;

    public ApiRequestData() {
    }

    /**
     * 通过 json 构造 ApiRequestData，注意返回结果不为 json 的 api（如果有的话）
     */
    @SuppressWarnings("unchecked")
    private ApiRequestData(Map<String, Object> attrs) {
        this.attrs = attrs;

        try {
            String temp = JSON.toJSONString(attrs, SerializerFeature.DisableCircularReferenceDetect);
            this.json = temp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ApiRequestData create(Map<String, Object> attrs) {
        return new ApiRequestData(attrs);
    }

    public Map<String, Object> getAttrs() {
        return attrs;
    }

    public void setAttrs(Map<String, Object> attrs) {
        this.attrs = attrs;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
