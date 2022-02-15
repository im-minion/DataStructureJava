package gfg.searching;

import java.util.Arrays;

/*
TODO : UTS
Smallest Difference Triplet from Three arrays
Difficulty Level : Medium

Three arrays of same size are given. Find a triplet such that maximum – minimum in that triplet is minimum of all the triplets.
A triplet should be selected in a way such that it should have one number from each of the three given arrays.

If there are 2 or more smallest difference triplets, then the one with the smallest sum of its elements should be displayed.

Examples :

Input : arr1[] = {5, 2, 8}
arr2[] = {10, 7, 12}
arr3[] = {9, 14, 6}
Output : 7, 6, 5

Input : arr1[] = {15, 12, 18, 9}
arr2[] = {10, 17, 13, 8}
arr3[] = {14, 16, 11, 5}
Output : 11, 10, 9
*/
public class SmallestDiffTriplet {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 8};
        int[] arr2 = {10, 7, 12};
        int[] arr3 = {9, 14, 6};

        int n = arr1.length;

        int[] op = smallestDifferenceTriplet(arr1, arr2, arr3, n);
        Arrays.stream(op).forEach(el -> System.out.print(el + " "));
    }

    private static int[] smallestDifferenceTriplet(int[] arr1, int[] arr2, int[] arr3, int n) {
        int[] op = new int[3];
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        Arrays.sort(arr3);

        int i = 0, j = 0, k = 0;

        int minDiff = Integer.MAX_VALUE;

        while (i < n && j < n && k < n) {
            int sum = arr1[i] + arr2[j] + arr3[k];
            int max = maxOf(arr1[i], arr2[j], arr3[k]);
            int min = minOf(arr1[i], arr2[j], arr3[k]);

            if (min == arr1[i])
                i++;
            else if (min == arr2[j])
                j++;
            else
                k++;

            int currDiff = max - min;
            if (currDiff < minDiff) {
                minDiff = currDiff;
                op[0] = max;
                op[1] = sum - (max + min);
                op[2] = min;
            }
        }

        return op;
    }

    private static int maxOf(int i, int i1, int i2) {
        return Math.max(i, Math.max(i1, i2));
    }

    private static int minOf(int i, int i1, int i2) {
        return Math.min(i, Math.min(i1, i2));
    }

}
