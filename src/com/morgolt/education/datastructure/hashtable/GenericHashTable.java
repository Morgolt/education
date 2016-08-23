package com.morgolt.education.datastructure.hashtable;

import com.sun.istack.internal.Nullable;

public interface GenericHashTable<K, V> {

    void put(K key, V value);

    V search(K key);

    void delete(K key);

    int size();

    class Entry<K, V> {
        private K key;
        private V value;
        @Nullable
        private Entry next;

        Entry(K key, V value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        void setNext(Entry next) {
            this.next = next;
        }

        Entry getNext() {
            return next;
        }
    }

}
