package com.ssxs.appmodel.page;

import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页泛型对象，用于存储分页时使用，里面包含了分页信息和需分页的数据集合。<br>
 * 所有序号从1开始，即使为0或者-1都会转为1。<br>
 * 此分页，与具体使用的orm无关，是纯分页对象。<br>
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/5/9 15:06
 * modifyTime:
 * modifyBy:
 */
public class PagingList<T> implements Serializable {
    private static final long serialVersionUID = -5996957318662781976L;

    /**
     * 第一页
     */
    private static final int FIRST_PAGE = 1;

    /**
     * 每页默认多少条记录
     */
    private static final int PAGE_SIZE = 10;

    /**
     * 数字0
     */
    private static final int NUM_ZERO = 0;

    /**
     * 顺序，升序
     */
    public static final String ASC = "asc";

    /**
     * 倒序，降序
     */
    public static final String DESC = "desc";

    /**
     * 当前页数，默认为第一页
     */
    private int pageNo = FIRST_PAGE;

    /**
     * 每页记录数，默认每页10条记录
     */
    private int pageSize = PAGE_SIZE;

    /**
     * 数据总记录
     */
    private int totalRecord;

    /**
     * 总页数
     */
    private int totalPage;

    /**
     * 数据记录开始
     */
    private int startRow;

    /**
     * 数据记录结束
     */
    private int endRow;

    /**
     * 是否存在上一页
     */
    private boolean isPrePage;

    /**
     * 是否存在下一页
     */
    private boolean isNextPage;

    /**
     * 查询的数据集合
     */
    private List<T> itemList = new ArrayList<>();

    /**
     * 增加一个新开关，是否需要分页，默认为true，需要分页就一定要传入totalRecord<br>
     * 不需要分页时，就把所有记录一起查出来返回，这个开关可以只返回所有数据。
     */
    private boolean needPaging = true;

    /**
     * 需要返回数据，这个开关可以只返回统计数
     */
    private boolean needItem = true;

    /**
     * 排序
     */
    private String orderBy = null;

    /**
     * 排序方向：asc与desc切换
     */
    private String order = null;

    /**
     * 默认每页10条记录
     */
    public PagingList() {
        this(10);
    }

    /**
     * 默认每页多少条记录
     *
     * @param pageSize
     */
    public PagingList(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 默认页数和每页多少条记录
     *
     * @param pageNo
     * @param pageSize
     */
    public PagingList(int pageNo, int pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }

    /**
     * 获取当前页数
     *
     * @return the currentPage 返回的当前页数
     */
    public int getPageNo() {
        return pageNo;
    }

    /**
     * 设置当前页数
     *
     * @param pageNo 要设置的当前页数
     */
    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
        if (pageNo < FIRST_PAGE) {
            pageNo = FIRST_PAGE;
        }
    }

    /**
     * 获取每页记录数
     *
     * @return the pageSize 返回的每页记录数
     */
    public int getPageSize() {
        return pageSize <= NUM_ZERO ? PAGE_SIZE : pageSize;
    }

    /**
     * 设置每页记录数
     *
     * @param pageSize 要设置的每页记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取总记录数
     *
     * @return the totalRecord 返回的总记录数
     */
    public int getTotalRecord() {
        return totalRecord;
    }

    /**
     * 设置总记录数
     *
     * @param totalRecord 要设置的总记录数
     */
    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    /**
     * 获取总页数
     *
     * @return the totalPage 返回的总页数
     */
    public int getTotalPage() {
        totalPage = this.getTotalRecord() / this.getPageSize();
        if (this.getTotalRecord() % this.getPageSize() > NUM_ZERO) {
            totalPage++;
        }
        return totalPage;
    }

    /**
     * 获取记录的开始点
     *
     * @return the startRow 返回的记录开始点
     */
    public int getStartRow() {
        startRow = this.getTotalRecord() == NUM_ZERO ? NUM_ZERO : (this.getPageNo() - 1) * this.getPageSize();
        return startRow;
    }

    /**
     * 获取记录的结束点
     *
     * @return the endRow 返回的记录结束点
     */
    public int getEndRow() {
        endRow = this.getTotalRecord() == NUM_ZERO ? NUM_ZERO : this.getPageNo() * this.getPageSize();
        return endRow;
    }

    /**
     * 是否有上一页
     *
     * @return the isPrePage 返回true为有或者false为无
     */
    public boolean isHasPrePage() {
        isPrePage = (this.getPageNo() - 1 >= 1);
        return isPrePage;
    }

    /**
     * 取得上一页的页号, 序号从1开始<br>
     * 当前页为首页时返回首页序号<br>
     *
     * @return
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 下午1:01:48
     */
    public int getPrevPage() {
        if (this.isHasPrePage()) {
            return pageNo - 1;
        } else {
            return pageNo;
        }
    }

    /**
     * 是否有下一页
     *
     * @return the isNextPage 返回true为有或者false为无
     */
    public boolean isHasNextPage() {
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
    public int getNextPage() {
        if (this.isHasNextPage()) {
            return pageNo + 1;
        } else {
            return pageNo;
        }
    }

    /**
     * 获取记录集合
     *
     * @return the itemList 返回的记录集合
     */
    public List<T> getItemList() {
        return itemList;
    }

    /**
     * 设置记录集合
     *
     * @param itemList 要设置的记录集合
     */
    public void setItemList(List<T> itemList) {
        this.itemList = itemList;
    }

    /**
     * 获取是否需要分页
     *
     * @return
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 下午12:01:18
     */
    public boolean isNeedPaging() {
        return needPaging;
    }

    /**
     * 设置是否需要分页
     *
     * @param needPaging
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 下午12:01:21
     */
    public void setNeedPaging(boolean needPaging) {
        this.needPaging = needPaging;
    }

    /**
     * 获得排序字段，无默认值。 多个排序字段时用','分隔。
     *
     * @return
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 上午11:59:12
     */
    public String getOrderBy() {
        return orderBy;
    }

    /**
     * 设置排序字段，多个排序字段时用','分隔。
     *
     * @param orderBy
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 上午11:59:32
     */
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    /**
     * 连续设置条件时使用
     *
     * @param orderBy
     * @return
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 下午12:07:13
     */
    public PagingList<T> orderBy(String orderBy) {
        setOrder(orderBy);
        return this;
    }

    /**
     * 获得排序方向，无默认值
     *
     * @return
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 下午12:00:14
     */
    public String getOrder() {
        return order;
    }

    /**
     * 设置排序方向
     *
     * @param order 可选值为desc或asc，多个排序字段时用','分隔。
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 下午12:00:23
     */
    public void setOrder(String order) {
        String lowcaseOrder = StringUtils.lowerCase(order);
        // 检查order字符串的合法值
        String[] orders = StringUtils.split(lowcaseOrder, ',');
        if (orders == null) {
            return;
        }
        for (String orderStr : orders) {
            if (!StringUtils.equals(DESC, orderStr) && !StringUtils.equals(ASC, orderStr)) {
                throw new IllegalArgumentException("排序方向" + orderStr + "不是合法值");
            }
        }
        this.order = lowcaseOrder;
    }

    /**
     * 用于连续设置时使用。
     *
     * @param order
     * @return
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 下午12:04:32
     */
    public PagingList<T> order(String order) {
        setOrder(order);
        return this;
    }

    /**
     * 是否已设置排序字段，无默认值。
     *
     * @return
     * @version V1.0.0
     * @author Haixiang Dai <br>
     * createTime: 2012-5-14 下午12:06:02
     */
    public boolean isOrderBySetted() {
        return (StringUtils.isNotBlank(orderBy) && StringUtils.isNotBlank(order));
    }

    public boolean isNeedItem() {
        return needItem;
    }

    public void setNeedItem(boolean needItem) {
        this.needItem = needItem;
    }

}
