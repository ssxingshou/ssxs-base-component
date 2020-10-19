package com.ssxs.apimodel.domain;

import com.alibaba.fastjson.JSON;
import com.ssxs.apimodel.vo.AbstractVo;

import java.util.Map;

/**
 * 响应要求规范为json格式
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2017/1/23 16:43
 * modifyTime:
 * modifyBy:
 */
public class ApiResponseData extends AbstractVo {
    private static final long serialVersionUID = -4128199631602007210L;
    /**
     * 属性
     */
    private Map<String, Object> attrs;
    /**
     * json数据
     */
    private String json;

    public ApiResponseData() {
    }

    /**
     * 通过 json 构造 ApiResponseData，注意返回结果不为 json 的 api（如果有的话）
     */
    @SuppressWarnings("unchecked")
    public ApiResponseData(String jsonStr) {
        this.json = jsonStr;

        try {
            Map<String, Object> temp = JSON.parseObject(jsonStr, Map.class);
            this.attrs = temp;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过 json 创建 ApiResponseData 对象，等价于 new ApiResponseData(jsonStr)
     */
    public static ApiResponseData create(String jsonStr) {
        return new ApiResponseData(jsonStr);
    }

    /**
     * 根据属性获取值
     *
     * @param name
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public <T> T get(String name) {
        return (T) attrs.get(name);
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
