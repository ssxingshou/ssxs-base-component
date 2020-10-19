package com.ssxs.apimodel.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright:
 * createTime: 2016/12/6 17:13
 * modifyTime:
 * modifyBy:
 */
public class PageVo<T> extends AbstractVo {
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
    /**
     * 是否存在下一页
     */
    private Boolean isNextPage = false;

    public PageVo() {
    }

    /**
     * 是否有下一页
     *
     * @return the isNextPage 返回true为有或者false为无
     */
    public Boolean isHasNextPage() {
        isNextPage = (this.pageNo + 1 <= this.getTotalPage());
        return isNextPage;
    }

    /**
     * 取得下一页的页号, 序号从1开始<br>
     * 当前页为尾页时仍返回尾页序号<br>
     *
     * @return
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 下午12:59:35
     */
    public Long getNextPage() {
        if (this.isHasNextPage()) {
            return pageNo + 1;
        } else {
            return pageNo;
        }
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
