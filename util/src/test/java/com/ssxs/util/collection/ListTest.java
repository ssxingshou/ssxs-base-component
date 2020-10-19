/**
 *
 */
package com.ssxs.util.collection;

import org.junit.Test;

import java.util.*;

/**
 * Collections.sort(names, (a, b) -> b.compareTo(a));
 * new Thread( () -> System.out.println("In Java8!") ).start();
 *
 * @version: v1.0
 * @author: Haixiang.Dai
 * project:
 * copyright: TECHNOLOGY CO., LTD. (c) 2015-2020
 * createTime: 2018/11/5 20:59
 * modifyTime:
 * modifyBy:
 */
public class ListTest {

    @Test
    public void testPerence() {
        List<Person> personList = new ArrayList<Person>();
        Person p1 = new Person();
        p1.setName("name1");
        p1.setSex("sex1");
        personList.add(p1);
        Person p2 = new Person();
        p2.setName("name2");
        p2.setSex("sex2");
        personList.add(p2);

        List<Person> personList2 = new ArrayList<Person>();
        int i = 0;
        for (Person person : personList) {
            person.setName(person.getName() + i);
            personList2.add(person);
            i = i + 1;
        }
        for (Person person : personList2) {
            System.out.println(person.getName());
        }
    }

    @Test
    public void test() {
        List<Long> wantIntoDbItemIds = new LinkedList<>();
        Set<Long> wantIntoDbItemIdsSet = new LinkedHashSet<>();
        List<Long> itemIdsInDb = new LinkedList<>();
        List<Long> itemIds = new LinkedList<>();
        itemIdsInDb.add(1L);
        itemIdsInDb.add(2L);

        itemIds.add(2L);
        itemIds.add(3L);

        wantIntoDbItemIdsSet.addAll(itemIdsInDb);
        wantIntoDbItemIdsSet.addAll(itemIds);
        wantIntoDbItemIds.addAll(wantIntoDbItemIdsSet);

        System.out.print("wantIntoDbItemIds:" + wantIntoDbItemIds);
    }
}
