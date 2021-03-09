package orderstatistics;

/*
Find the smallest missing number
Difficulty Level : Medium

Given a sorted array of n distinct integers where each integer is in the range from 0 to m-1 and m > n. Find the smallest number that is missing from the array.

Examples

Input: {0, 1, 2, 6, 9}, n = 5, m = 10
Output: 3

Input: {4, 5, 10, 11}, n = 4, m = 12
Output: 0

Input: {0, 1, 2, 3}, n = 4, m = 5
Output: 4

Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
Output: 8

*/
public class SmallestMissingNumber {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 10};
        int op = findSmallestMissingInSortedArray(arr);
        System.out.println(op);
    }

    private static int findSmallestMissingInSortedArray(int[] arr) {
        int i;
        for (i = 0; i < arr.length; i++) {
            try {
                if (arr[i] != i) {
                    return i;
                }
            } catch (ArithmeticException e) {
                return i;
            }
        }
        return i + 1;
    }
}
