package sorting;
/*
Merge an array of size n into another array of size m+n
Difficulty Level : Easy

There are two sorted arrays.
First one is of size m+n containing only m elements.
Another one is of size n and contains n elements. Merge these two arrays into the first array of size m+n such that the output is sorted.
Input: array with m+n elements (mPlusN[]).
*/

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] mPlusN = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int[] N = {5, 7, 9, 25};

        doMerge(mPlusN, N);

        Arrays.stream(mPlusN).forEach(a -> System.out.print(a + " "));

        System.out.println();

        // TODO: UTS second approach
        mPlusN = new int[]{2, 8, -1, -1, -1, 13, -1, 15, 20};
        N = new int[]{5, 7, 9, 25};

        doMergeAdvanced(mPlusN, N);

        Arrays.stream(mPlusN).forEach(a -> System.out.print(a + " "));
    }

    private static void doMergeAdvanced(int[] arr1, int[] arr2) {
        int n = arr2.length;
        int m = arr1.length - n;

        /*Move the m elements at the end of mPlusN*/
        moveToEnd(arr1, m + n);

        merge(arr1, arr2, m, n);
    }

    /*Merge N[] into mPlusN[] */
    private static void merge(int[] arr1, int[] arr2, int m, int n) {
        int i = n;

        /* Current index of i/p part of mPlusN[]*/
        int j = 0;

        /* Current index of N[]*/
        int k = 0;

        /* Current index of output mPlusN[]*/
        while (k < (m + n)) {
            /* Take an element from mPlusN[] if
            a) value of the picked element is smaller and we
            have not reached end of it b) We have reached
            end of N[] */
            if ((i < (m + n) && arr1[i] <= arr2[j])
                    || (j == n)) {
                arr1[k] = arr1[i];
                k++;
                i++;
            } else // Otherwise take element from N[]
            {
                arr1[k] = arr2[j];
                k++;
                j++;
            }
        }
    }

    private static void moveToEnd(int[] mPlusN, int size) {
        int i, j = size - 1;
        for (i = size - 1; i >= 0; i--) {
            if (mPlusN[i] != -1) {
                mPlusN[j] = mPlusN[i];
                j--;
            }
        }
    }

    // O(nlogn)
    private static void doMerge(int[] arr, int[] arr2) {
        int i = 0;
        int j = 0;
        while (i < arr.length && j < arr2.length) {
            if (arr[i] == -1) {
                arr[i] = arr2[j];
                i++;
                j++;
            } else {
                i++;
            }
        }
        Arrays.sort(arr);
    }
}
