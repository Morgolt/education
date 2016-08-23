package com.morgolt.education.algorithms;

public class MergeSort {

    public void sort(Comparable[] array) {
        if (array.length <= 1)
            return;

        Comparable[] left = new Comparable[array.length/2];
        Comparable[] right = new Comparable[array.length - left.length];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);

        sort(left);
        sort(right);

        merge(left, right, array);
    }

    @SuppressWarnings("unchecked")
    void merge(Comparable[] left, Comparable[] right, Comparable[] array) {
        int first = 0;
        int second = 0;
        int merged = 0;

        while(first < left.length && second < right.length) {
            if(left[first].compareTo(right[second])<0) {
                array[merged] = left[first++];
            } else {
                array[merged] = right[second++];
            }
            merged++;
        }
        System.arraycopy(left, first, array, merged, left.length - first);
        System.arraycopy(right, second, array, merged, right.length - second);
    }
}
