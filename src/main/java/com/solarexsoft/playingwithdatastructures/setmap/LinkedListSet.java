package com.solarexsoft.playingwithdatastructures.setmap;

import com.solarexsoft.playingwithdatastructures.list.SolarexLinkedList;

/**
 * Created by houruhou on 2019/9/28.
 * Desc:
 */
public class LinkedListSet<E> implements Set<E> {
    private SolarexLinkedList<E> list;

    public LinkedListSet() {
        list = new SolarexLinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e)) {
            list.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
