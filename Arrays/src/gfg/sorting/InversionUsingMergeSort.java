package gfg.sorting;

/*
TODO: Do this with merge Sort
Count Inversions in an array | Set 1 (Using Merge Sort)
Difficulty Level : Hard

Inversion Count for an array indicates – how far (or close) the array is from being sorted.
If the array is already sorted, then the inversion count is 0, but if the array is sorted in the reverse order,
 the inversion count is the maximum.
Formally speaking, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j
Example:

Input: arr[] = {8, 4, 2, 1}
Output: 6

Explanation: Given array has six inversions:
(8, 4), (4, 2), (8, 2), (8, 1), (4, 1), (2, 1).


Input: arr[] = {3, 1, 2}
Output: 2

Explanation: Given array has two inversions:
(3, 1), (3, 2)
*/
public class InversionUsingMergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 20, 6, 4, 5};
        System.out.println("Number of inversions are " + getInvCount(arr));
    }

    private static int getInvCount(int[] arr) {
        int inv = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    inv++;
                }
            }
        }
        return inv;
    }
}
