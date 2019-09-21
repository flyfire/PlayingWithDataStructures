package com.solarexsoft.playingwithdatastructures.stacks;

import com.solarexsoft.playingwithdatastructures.arrays.SolarexArray;

/**
 * Created by houruhou on 2019/3/4.
 * Desc:
 */
public class SolarexArrayStack<E> implements Stack<E> {

    private SolarexArray<E> array;

    public SolarexArrayStack(int capacity) {
        array = new SolarexArray<>(capacity);
    }

    public SolarexArrayStack() {
        array = new SolarexArray<>();
    }
    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for(int i = 0 ; i < array.getSize() ; i ++){
            res.append(array.get(i));
            if(i != array.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }
}
