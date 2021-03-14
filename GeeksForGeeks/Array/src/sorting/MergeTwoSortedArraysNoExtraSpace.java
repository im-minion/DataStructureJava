package sorting;

import java.util.Arrays;

/*
TODO: Little Difficult!!
Merge two sorted arrays with O(1) extra space
Difficulty Level : Medium

We are given two sorted arrays.
We need to merge these two arrays such that the initial numbers (after complete sorting) are in the first array and
the remaining numbers are in the second array.
Extra space allowed in O(1).

Example:

Input:
ar1[] = {10};
ar2[] = {2, 3};
Output:
ar1[] = {2}
ar2[] = {3, 10}

Input:
ar1[] = {1, 5, 9, 10, 15, 20};
ar2[] = {2, 3, 8, 13};
Output:
ar1[] = {1, 2, 3, 5, 8, 9}
ar2[] = {10, 13, 15, 20}
*/
public class MergeTwoSortedArraysNoExtraSpace {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 5, 9, 10, 15, 20};
        int[] arr2 = new int[]{2, 3, 8, 13};
        merge(arr1, arr2);
        Arrays.stream(arr1).forEach(a -> System.out.print(a + " "));
        Arrays.stream(arr2).forEach(a -> System.out.print(a + " "));
    }

    private static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        // Iterate through all elements of ar2[] starting from the last element
        for (int i = n - 1; i >= 0; i--) {
            /* Find the smallest element greater than ar2[i].
            Move all elements one position ahead till the smallest greater element is not found */
            int j, last = arr1[m - 1];
            for (j = m - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
                arr1[j + 1] = arr1[j];
            }
            // If there was a greater element
            if (j != m - 2 || last > arr2[i]) {
                arr1[j + 1] = arr2[i];
                arr2[i] = last;
            }
        }
    }
}
