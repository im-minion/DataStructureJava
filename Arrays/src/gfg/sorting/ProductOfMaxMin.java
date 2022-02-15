package gfg.sorting;

import java.util.Arrays;

/*
Product of maximum in first array and minimum in second
Difficulty Level : Basic

Given two arrays, the task is to calculate the product of max element of first array and min element of second array

References : Asked in Adobe (Source : Careercup)

Examples :

Input :
arr1[] = {5, 7, 9, 3, 6, 2},
arr2[] = {1, 2, 6, -1, 0, 9}
Output : max element in first array is 9 and min element in second array is -1. The product of these two is -9.

Input :
arr1[] = {1, 4, 2, 3, 10, 2},
arr2[] = {4, 2, 6, 5, 2, 9}
Output :
max element in first array is 10 and min element in second array is 2. The product of these two is 20.
*/
public class ProductOfMaxMin {
    public static void main(String[] args) {
        int[] arr1 = new int[]{10, 2, 3, 6, 4, 1};
        int[] arr2 = new int[]{5, 1, 4, 2, 6, 9};
        int n1 = arr1.length;
        int n2 = arr2.length;
        System.out.println(minMaxProduct(arr1, arr2, n1, n2));
    }

    private static int minMaxProduct(int[] arr1, int[] arr2, int n1, int n2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return arr1[n1 - 1] * arr2[0];
    }
}
