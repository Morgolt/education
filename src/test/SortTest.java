package test;

import com.morgolt.education.algorithms.GenericSorter;
import com.morgolt.education.algorithms.MergeSort;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SortTest {
    GenericSorter sorter;
    static final Integer[] SORTED_ARRAY = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    Integer[] testArray = new Integer[]{10, 2, 4, 3, 5, 6, 1, 8, 7, 9};

    @Test
    public void mergeSort() throws Exception {
        sorter = (Comparable[] a) -> {
            MergeSort merger = new MergeSort();
            merger.sort(a);
        };
        sorter.sort(testArray);
        assertArrayEquals(SORTED_ARRAY, testArray);
    }

}