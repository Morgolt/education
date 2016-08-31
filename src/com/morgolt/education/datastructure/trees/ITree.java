package com.morgolt.education.datastructure.trees;

import java.util.function.Consumer;

public interface ITree<K, V> {

    void insert(K key, V value);

    void delete(K key);

    V search(K key);

    void traverse(Consumer consumer);

    boolean contains(K key);

    int getCount();
}
