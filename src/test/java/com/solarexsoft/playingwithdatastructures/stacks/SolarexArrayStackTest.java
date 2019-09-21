package com.solarexsoft.playingwithdatastructures.stacks;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/3/4.
 * Desc:
 */
public class SolarexArrayStackTest {
    @Test
    public void testStack() {
        SolarexArrayStack<Integer> stack = new SolarexArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
    }
}