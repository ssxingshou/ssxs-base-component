/**
 *
 */
package com.ssxs.util.concurrent.locks;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 21:02
 * modifyTime:
 * modifyBy:
 */
public class ConcurrentHashMapTest {

    public static Map<Object, Object> map = new ConcurrentHashMap<Object, Object>();
    // public static Map<Object, Object> map = new HashMap<Object, Object>();
    public static int count = 1000;

    static {
        for (int i = 0; i < count; i++) {
            map.put(i, i);
        }
    }

    public static void main(String[] args) {

        Thread iteratorThread = new Thread(new IteratorThread());
        iteratorThread.start();
        Thread removeThread = new Thread(new RemoveThread());
        removeThread.start();

    }

    static class IteratorThread implements Runnable {

        @Override
        public void run() {
            for (Map.Entry<Object, Object> entry : map.entrySet()) {
                System.out.println(entry);
            }
            System.out.println("size:" + map.size());
        }
    }

    static class RemoveThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < count; i++) {
                if (i % 2 == 0) {
                    map.remove(i);
                    System.out.println("remove:" + i);
                }
            }
            System.out.println("size:" + map.size());
        }
    }

}
