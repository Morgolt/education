package com.morgolt.education.datastructure.stack;

import java.util.Arrays;

public class ArrayStack<T> implements GenericStack<T>{

    private static int DEFAULT_SIZE = 16;
    private static double LOAD_FACTOR = 0.75;
    private int position;

    private T[] stack;

    public ArrayStack() {
        stack = (T[]) new Object[DEFAULT_SIZE];
    }

    public ArrayStack(int capacity) {
        this.stack = (T[]) new Object[capacity];
    }

    public int size() {
        return position;
    }

    public boolean isEmpty() {
        return position == 0;
    }

    public void push(T data) {
        if (position > stack.length * LOAD_FACTOR)
            resize(stack.length * 2);
        stack[position++] = data;
    }

    public T peek() {
        if(position != 0)
            return stack[position - 1];
        else
            return null;
    }

    public T pop() {
        if (position == 0) {
            return null;
        }
        if (position * 3 < stack.length) {
            resize(position * 2);
        }
        T data = stack[--position];
        stack[position] = null;
        return data;
    }

    private void resize(int newSize) {
        stack = Arrays.copyOf(stack, newSize);
    }
}
