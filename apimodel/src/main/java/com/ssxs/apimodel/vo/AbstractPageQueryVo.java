package com.ssxs.apimodel.vo;

/**
 * 抽象的分页查询vo
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/12/13 17:55
 * modifyTime:
 * modifyBy:
 */
public class AbstractPageQueryVo extends AbstractVo {
    private static final long serialVersionUID = 3578732888753838320L;
    /**
     * 每页多少条记录
     */
    private Long pageSize = 10L;
    /**
     * 当前页
     */
    private Long pageNo = 1L;

    public AbstractPageQueryVo() {
    }

    public Long getPageSize() {
        if (pageSize == null) {
            pageSize = 10L;
        }
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getPageNo() {
        if (pageNo == null) {
            pageNo = 1L;
        }
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

}
