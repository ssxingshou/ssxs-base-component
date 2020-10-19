package com.ssxs.util.domain;

import java.util.concurrent.CountDownLatch;

/**
 * 运动员线程
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:04
 * modifyTime:
 * modifyBy:
 */
public class Player implements Runnable {

    private int id;
    private CountDownLatch begin;
    private CountDownLatch end;

    public Player(int i, CountDownLatch begin, CountDownLatch end) {
        super();
        this.id = i;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        try {
            begin.await(); // 等待begin的状态为0
            Thread.sleep((long) (Math.random() * 100)); // 随机分配时间，即运动员完成时间
            System.out.println("Play" + id + " arrived.");
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            end.countDown(); // 使end状态减1，最终减至0
        }
    }

}
