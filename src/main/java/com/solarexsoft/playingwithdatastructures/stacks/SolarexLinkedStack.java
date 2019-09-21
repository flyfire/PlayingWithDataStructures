package com.solarexsoft.playingwithdatastructures.stacks;

import com.solarexsoft.playingwithdatastructures.list.SolarexLinkedList;

/**
 * Created by houruhou on 2019/9/21.
 * Desc:
 */
public class SolarexLinkedStack<E> implements Stack<E> {
    private SolarexLinkedList<E> linkedList;

    public SolarexLinkedStack() {
        linkedList = new SolarexLinkedList<>();
    }
    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    @Override
    public void push(E e) {
        linkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return linkedList.removeFirst();
    }

    @Override
    public E peek() {
        return linkedList.getFirst();
    }
}
