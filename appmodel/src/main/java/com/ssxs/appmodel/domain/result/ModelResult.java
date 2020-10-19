/**
 *
 */
package com.ssxs.appmodel.domain.result;

/**
 * 针对单个对象返回的结果封装
 * 根据某id/no去数据表里查询，如果查不到时(没有故障)，success为true而model为null
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:19
 * modifyTime:
 * modifyBy:
 */
@SuppressWarnings("rawtypes")
public class ModelResult<T> extends BaseResult {
    private static final long serialVersionUID = -2694376657933606507L;
    /**
     * 模型
     */
    private T model;
    /**
     * 是否读取自缓存，默认值不能随便改
     */
    private boolean readFromCache = false;

    public ModelResult() {
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public <SubClass extends ModelResult> SubClass withModel(T model) {
        this.model = model;
        return (SubClass) this;
    }

    public <SubClass extends ModelResult> SubClass withModelFromCache(T model) {
        this.model = model;
        this.readFromCache = true;
        return (SubClass) this;
    }

    public <SubClass extends ModelResult> SubClass withModelFromDb(T model) {
        this.model = model;
        return (SubClass) this;
    }

    public boolean isReadFromCache() {
        return readFromCache;
    }

    public void setReadFromCache(boolean readFromCache) {
        this.readFromCache = readFromCache;
    }

}
