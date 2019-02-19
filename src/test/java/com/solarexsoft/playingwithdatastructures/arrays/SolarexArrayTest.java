package com.solarexsoft.playingwithdatastructures.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/2/19.
 * Desc:
 */
public class SolarexArrayTest {
    @Test
    public void test() {
        SolarexArray<Integer> arr = new SolarexArray<>();
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(-1);
        System.out.println(arr);

        arr.remove(2);
        System.out.println(arr);

        arr.removeElement(4);
        System.out.println(arr);

        arr.removeFirst();
        System.out.println(arr);

        for (int i = 0; i < 4; i++) {
            arr.removeFirst();
            System.out.println(arr);
        }
    }
}