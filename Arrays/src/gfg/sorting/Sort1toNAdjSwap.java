package gfg.sorting;
/*
Sort 1 to N by swapping adjacent elements
Difficulty Level : Medium

Given an array, A of size N consisting of elements 1 to N.
A boolean array B consisting of N-1 elements indicates that if B[i] is 1, then A[i] can be swapped with A[i+1].
Find out if A can be sorted by swapping elements.

Examples:

Input : A[] = {1, 2, 5, 3, 4, 6}
B[] = {0, 1, 1, 1, 0}
Output : A can be sorted we can swap A[2] with A[3] and then A[3] with A[4].

Input : A[] = {2, 3, 1, 4, 5, 6}
B[] = {0, 1, 1, 1, 1}
Output : A can not be sorted We can not sort A by swapping elements as 1 can never be swapped with A[0]=2.
*/

public class Sort1toNAdjSwap {
    public static void main(String[] args) {
        int[] A = {1, 2, 5, 3, 4, 6};
        int[] B = {0, 1, 1, 1, 0};
        int n = A.length;

        if (sortedAfterSwap(A, B, n) == 0)
            System.out.println("A can be sorted");
        else
            System.out.println("A can not be sorted");
    }

    private static int sortedAfterSwap(int[] arr, int[] brr, int n) {
        int t = 0;
        for (int i = 0; i < n - 1; i++) {
            if (brr[i] != 0) {
                if (arr[i] != i + 1) {
                    t = arr[i];

                }
                arr[i] = arr[i + 1];
                arr[i + 1] = t;
            }
        }

        // Check if array is sorted or not
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1)
                return 0;
        }

        return 1;
    }
}
