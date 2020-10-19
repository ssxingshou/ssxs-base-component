package com.ssxs.apimodel.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页Dto
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright:
 * createTime: 2016/12/6 17:13
 * modifyTime:
 * modifyBy:
 */
public class MongoPageDto<T> extends AbstractDto {
    private static final long serialVersionUID = 6531656959856945065L;
    /**
     * 第一页
     */
    private static final Long FIRST_PAGE = 1L;
    /**
     * 每页默认多少条记录
     */
    private static final Long PAGE_SIZE = 10L;
    /**
     * 当前页数，默认为第一页
     */
    private Long pageNo = FIRST_PAGE;
    /**
     * 每页记录数，默认每页10条记录
     */
    private Long pageSize = PAGE_SIZE;
    /**
     * 数据总记录
     */
    private Long totalRecord = 0L;
    /**
     * 总页数
     */
    private Long totalPage = 0L;
    /**
     * 查询的数据集合
     */
    private List<T> itemList = new ArrayList<>();

    public MongoPageDto() {
    }

    public Long getPageNo() {
        return pageNo;
    }

    public void setPageNo(Long pageNo) {
        this.pageNo = pageNo;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }
}
