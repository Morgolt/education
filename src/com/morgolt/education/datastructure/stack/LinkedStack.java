package com.morgolt.education.datastructure.stack;

public class LinkedStack<T> implements GenericStack<T> {

    private Node<T> head;
    private int count;

    @Override
    public void push(T data) {
        if (count == 0) {
            head = new Node<>(data, null);
            count++;
        } else {
            head = new Node<T>(data, head);
            count++;
        }
    }

    @Override
    public T peek() {
        if (count == 0)
            return null;
        return head.data;
    }

    @Override
    public T pop() {
        if (count == 0)
            return null;

        T result = head.data;
        head = head.next;
        count--;
        return result;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count==0;
    }

    private class Node<T> {
        T data;
        Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }


}
