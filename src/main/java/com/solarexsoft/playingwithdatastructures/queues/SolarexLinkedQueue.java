package com.solarexsoft.playingwithdatastructures.queues;

/**
 * Created by houruhou on 2019/9/21.
 * Desc:
 */
public class SolarexLinkedQueue<E> implements Queue<E> {
    static class Node<E> {
        E e;
        Node<E> next;

        public Node(E e,Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    Node<E> head,tail;
    int size;
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node<>(e);
            head = tail;
        } else {
            tail.next = new Node<>(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cant dequeue from an empty queue");
        }
        Node<E> retNode = head;
        head = retNode.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("cant get from empty queue");
        }
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedQueue front: ");
        Node<E> cur = head;
        while (cur != null) {
            sb.append(cur + " -> ");
            cur = cur.next;
        }
        sb.append("null tail\n");
        return sb.toString();
    }
}
