package com.morgolt.education.datastructure.trees;

import java.util.function.Consumer;

public interface IBinaryTree<K, V> {

    void insert(K key, V value);

    void delete(K key);

    V search(K key);

    void infixTraverse(Consumer consumer);

    boolean contains(K key);

    int getCount();
}
