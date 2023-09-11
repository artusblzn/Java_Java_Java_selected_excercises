package chapter09.test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;
import chapter09.MergeSort;

public class MergeSortTests {
    private MergeSort mSort = new MergeSort();

    @Test
    public void testMerge() {
        int[] sortedArray1 = {7, 10, 19, 20};
        int[] sortedArray2 = {9, 12, 17, 19, 21};
        int[] resultingArray = {7, 9, 10, 12, 17, 19, 19, 20, 21};
        assertArrayEquals(this.mSort.merge(sortedArray1, sortedArray2), resultingArray);
    }

    @Test
    public void testSort() {
        int[] unsortedArray = {20, 19, 10, 7};
        int[] sortedArray = {7, 10, 19, 20};
        assertArrayEquals(this.mSort.sort(unsortedArray), sortedArray);
    }

    @Test
    public void testSortTwoArrays() {
        int[] unsortedArray1 = {20, 19, 10, 7};
        int[] unsortedArray2 = {21, 19, 17, 12, 9};
        int[] sortedArray = {7, 9, 10, 12, 17, 19, 19, 20, 21};
        assertArrayEquals(this.mSort.sort(unsortedArray1, unsortedArray2), sortedArray);
    }

}
