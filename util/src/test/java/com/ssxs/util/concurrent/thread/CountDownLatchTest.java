/**
 *
 */
package com.ssxs.util.concurrent.thread;

import com.ssxs.util.domain.Player;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 20:59
 * modifyTime:
 * modifyBy:
 */
public class CountDownLatchTest {

    private static final int PLAYER_AMOUNT = 5;

    @Test
    public void testCountDownLatch() {
        // 对于每位运动员，CountDownLatch减1后即结束比赛
        CountDownLatch begin = new CountDownLatch(1);
        // 对于整个比赛，所有运动员结束后才算结束
        CountDownLatch end = new CountDownLatch(PLAYER_AMOUNT);
        Player[] plays = new Player[PLAYER_AMOUNT];

        for (int i = 0; i < PLAYER_AMOUNT; i++)
            plays[i] = new Player(i + 1, begin, end);

        // 设置特定的线程池，大小为5
        ExecutorService exe = Executors.newFixedThreadPool(PLAYER_AMOUNT);
        for (Player p : plays) {
            exe.execute(p); // 分配线程
        }
        System.out.println("Race begins!");
        begin.countDown();
        try {
            end.await(); // 等待end状态变为0，即为比赛结束
        } catch (InterruptedException e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            System.out.println("Race ends!");
        }
//		exe.shutdown();
    }

}
