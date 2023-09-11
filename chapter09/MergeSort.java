/**
 * EXERCISE 9.21 The merge sort algorithm takes two collections of data that have been sorted and
 * merges them together. Write a program that takes two 25-element int arrays, sorts them, and then
 * merges them, in order, into one 50-element array.
 */

package chapter09;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MergeSort {

    public int[] sort(int[] array) {
        if (array.length == 1) {
            return array;
        }

        int mid = array.length / 2;
        int[] firstPart = this.sort(Arrays.stream(array, 0, mid).toArray());
        int[] secondPart = this.sort(Arrays.stream(array, mid, array.length).toArray());

        return this.merge(firstPart, secondPart);
    }

    public int[] sort(int[] array1, int[] array2) {
        int[] concatenatedArray =
                IntStream.concat(IntStream.of(array1), IntStream.of(array2)).toArray();
        return this.sort(concatenatedArray);
    }

    public int[] merge(int[] sortedArray1, int[] sortedArray2) {
        int[] mergedArray = new int[sortedArray1.length + sortedArray2.length];
        int sortedArray1Index = 0;
        int sortedArray2Index = 0;

        for (int mergedArrayIndex = 0; mergedArrayIndex < mergedArray.length; mergedArrayIndex++) {
            if (sortedArray1Index >= sortedArray1.length) {
                mergedArray[mergedArrayIndex] = sortedArray2[sortedArray2Index++];
            } else if (sortedArray2Index >= sortedArray2.length) {
                mergedArray[mergedArrayIndex] = sortedArray1[sortedArray1Index++];
            } else if (sortedArray1[sortedArray1Index] <= sortedArray2[sortedArray2Index]) {
                mergedArray[mergedArrayIndex] = sortedArray1[sortedArray1Index++];
            } else {
                mergedArray[mergedArrayIndex] = sortedArray2[sortedArray2Index++];
            }
        }

        return mergedArray;
    }

}
