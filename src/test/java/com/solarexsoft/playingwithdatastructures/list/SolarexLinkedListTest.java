package com.solarexsoft.playingwithdatastructures.list;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/9/21.
 * Desc:
 */
public class SolarexLinkedListTest {
    @Test
    public void testLinkedList() {
        SolarexLinkedList<Integer> linkedList = new SolarexLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
        linkedList.add(2, 233);
        System.out.printf(linkedList.toString());
        linkedList.remove(2);
        System.out.printf(linkedList.toString());
        linkedList.removeFirst();
        System.out.printf(linkedList.toString());
        linkedList.removeLast();
        System.out.printf(linkedList.toString());
    }

}