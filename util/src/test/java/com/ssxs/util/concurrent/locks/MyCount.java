/**
 *
 */
package com.ssxs.util.concurrent.locks;

/**
 * 信用卡账户，可随意透支
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:02
 * modifyTime:
 * modifyBy:
 */
public class MyCount {

    private String oid; // 账号
    private int cash; // 账户余额

    MyCount(String oid, int cash) {
        this.oid = oid;
        this.cash = cash;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

}
