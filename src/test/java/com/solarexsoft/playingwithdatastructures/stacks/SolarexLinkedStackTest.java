package com.solarexsoft.playingwithdatastructures.stacks;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Created by houruhou on 2019/9/21.
 * Desc:
 */
public class SolarexLinkedStackTest {

    private double testStack(Stack<Integer> stack, int opCount) {
        long start = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }
        long ellipse = System.nanoTime() - start;
        return ellipse/1000000000.0;
    }

    @Test
    public void test() {
        int op = 1000000;
        SolarexArrayStack<Integer> arrayStack = new SolarexArrayStack<>();
        System.out.println("ArrayStack cost " + testStack(arrayStack, op) + " s");
        SolarexLinkedStack<Integer> linkedStack = new SolarexLinkedStack<>();
        System.out.println("LinkedStack cost " + testStack(linkedStack, op) + " s");
        /*
        ArrayStack cost 0.083401358 s
        LinkedStack cost 0.229727438 s
         */
    }

    @Test
    public void testLinkedStack() {
        SolarexLinkedStack<Integer> linkedStack = new SolarexLinkedStack<>();
        for (int i = 0; i < 5; i++) {
            linkedStack.push(i);
            System.out.print(linkedStack);
        }
        linkedStack.pop();
        System.out.print(linkedStack);
    }
}