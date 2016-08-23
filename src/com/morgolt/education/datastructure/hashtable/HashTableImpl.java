package com.morgolt.education.datastructure.hashtable;


import com.sun.istack.internal.Nullable;

public class HashTableImpl<K, V> implements GenericHashTable<K, V> {

    private static final float LOAD_FACTOR = 0.75f;
    private static final int DEFAULT_SIZE = 16;

    private int count = 0;

    private GenericHashTable.Entry[] entries;

    public HashTableImpl() {
        entries = new GenericHashTable.Entry[DEFAULT_SIZE];
    }

    public HashTableImpl(int size) {
        entries = new GenericHashTable.Entry[size];
    }

    @Override
    @SuppressWarnings("unchecked")
    public void put(K key, V value) {
        int index = getIndex(key);
        if (entries[index] == null) {
            entries[index] = new GenericHashTable.Entry<>(key, value, null);
        }
        else {
            Entry e = entries[index];
            while(e.getNext() != null) {
                e = e.getNext();
            }
            e.setNext(new Entry(key, value, null));
        }
        count++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public V search(K key) {
        int index = getIndex(key);
        Entry entry = searchInList(entries[index], key);
        if(entry == null) {
            return null;
        }
        return (V) entry.getValue();
    }

    @Override
    public void delete(K key) {
        int index = getIndex(key);
        Entry prev = entries[index];
        Entry entry = prev;
        while (entry != null) {
            if (entry.getKey().equals(key)) {
                count--;
                if (prev == entry) {
                    entries[index] = null;
                } else {
                    prev.setNext(entry.getNext());
                }
                return;
            }
            prev = entry;
            entry = entry.getNext();
        }
    }

    @Override
    public int size() {
        return count;
    }

    private int getIndex(K key) {
        return key.hashCode() % entries.length;
    }

    @Nullable
    private Entry searchInList(Entry entry, K key) {
        while (entry != null) {
            if(entry.getKey().equals(key))
                return entry;

            entry = entry.getNext();
        }
        return null;
    }
}
