package gfg.sorting;

import java.util.Arrays;

/*
Count all distinct pairs with difference equal to k
Difficulty Level : Medium

Given an integer array and a positive integer k, count all distinct pairs with difference equal to k.
Examples:

Input: arr[] = {1, 5, 3, 4, 2}, k = 3
Output: 2
There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2}

Input: arr[] = {8, 12, 16, 4, 0, 20}, k = 4
Output: 5
There are 5 pairs with difference 4, the pairs are {0, 4}, {4, 8},
{8, 12}, {12, 16} and {16, 20}
*/
public class CountAllDistinctPairs {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 4, 2};
        int n = arr.length;
        int k = 3;
        System.out.println("Count of pairs with given diff is " + countPairsWithDiffK(arr, n, k));
    }

    private static int countPairsWithDiffK(int[] arr, int n, int k) {
        int count = 0;
        int i = 0;
        int j = 0;
        Arrays.sort(arr);
        while (j < n) {
            int currDiff = arr[j] - arr[i];
            if (currDiff == k) {
                count++;
                i++;
                j++;
            } else if (currDiff > k) {
                i++;
            } else {
                j++;
            }
        }
        return count;
    }
}
