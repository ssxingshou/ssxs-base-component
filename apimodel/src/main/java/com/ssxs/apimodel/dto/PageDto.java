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
public class PageDto<T> extends AbstractDto {
    private static final long serialVersionUID = 6531656959856945065L;
    /**
     * 第一页
     */
    private static final int FIRST_PAGE = 1;
    /**
     * 每页默认多少条记录
     */
    private static final int PAGE_SIZE = 10;
    /**
     * 当前页数，默认为第一页
     */
    private int pageNo = FIRST_PAGE;
    /**
     * 每页记录数，默认每页10条记录
     */
    private int pageSize = PAGE_SIZE;
    /**
     * initMinPageSize
     */
    private int initMinPageSize = 10;
    /**
     * initMaxPageSize
     */
    private int initMaxPageSize = 20;
    /**
     * 数据总记录
     */
    private long totalRecord;
    /**
     * 总页数
     */
    private int totalPage;
    /**
     * 查询的数据集合
     */
    private List<T> itemList = new ArrayList<>();

    public PageDto() {
    }

    public PageDto(int pageNo, int pageSize, int totalRecord, int totalPage) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
    }

    public int getPageNo() {
        if (pageNo < 1) {
            return 1;
        }
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        if (pageSize < 1) {
            return initMinPageSize;
        }
        if (pageSize > initMaxPageSize) {
            return initMaxPageSize;
        }

        return pageSize;
    }

    public void setPageSize(int pageSize) {

        this.pageSize = pageSize;
    }

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItemList() {
        return itemList;
    }

    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }

}
