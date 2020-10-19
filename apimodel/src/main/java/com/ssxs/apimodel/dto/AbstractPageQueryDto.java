package com.ssxs.apimodel.dto;

/**
 * 抽象的分页查询Dto
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2016
 * createTime: 2016/12/13 17:55
 * modifyTime:
 * modifyBy:
 */
public class AbstractPageQueryDto extends AbstractDto {
    private static final long serialVersionUID = 3578732888753838320L;
    /**
     * 客户端clientId
     */
    private String clientId;
    /**
     * 每页多少条记录
     */
    private Integer pageSize = 10;
    /**
     * 当前页
     */
    private Integer pageNo = 1;

    public AbstractPageQueryDto() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Integer getPageSize() {
        if (pageSize == null || pageSize <= 0) pageSize = 10;
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        if (pageNo == null || pageNo <= 0) pageNo = 1;
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }
}
