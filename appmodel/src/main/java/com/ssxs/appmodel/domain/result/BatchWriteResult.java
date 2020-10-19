package com.ssxs.appmodel.domain.result;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 批量写入记录的返回结果封装
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:18
 * modifyTime:
 * modifyBy:
 */
@SuppressWarnings("rawtypes")
public class BatchWriteResult<F> extends BaseResult {
    private static final long serialVersionUID = 6616231153777260275L;
    /**
     * 由接口实现方确定返回idList，还是DO List
     */
    private Collection successList = new ArrayList();
    /**
     * 一般返回idList，对于insert List的可返回 DO List
     */
    private Collection<F> failList = new ArrayList<>();

    /**
     * 失败
     *
     * @return
     */
    public boolean isFailure() {
        return !isSuccess();
    }

    /**
     * 如果有一个写入记录成功，就算成功
     */
    @Override
    public boolean isSuccess() {
        super.isSuccess();
        if (successList.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public <SubClass extends BatchWriteResult> SubClass withSuccessList(Collection successList) {
        this.successList = successList;
        return (SubClass) this;
    }

    public <SubClass extends BatchWriteResult> SubClass withFailList(Collection<F> failList) {
        this.failList = failList;
        return (SubClass) this;
    }

    public Collection getSuccessList() {
        return successList;
    }

    public void setSuccessList(Collection successList) {
        this.successList = successList;
    }

    public Collection<F> getFailList() {
        return failList;
    }

    public void setFailList(Collection<F> failList) {
        this.failList = failList;
    }
}
