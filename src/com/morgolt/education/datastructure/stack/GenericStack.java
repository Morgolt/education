package com.morgolt.education.datastructure.stack;

public interface GenericStack<T> {

    void push(T data);

    T peek();

    T pop();

    int size();

    boolean isEmpty();

}
