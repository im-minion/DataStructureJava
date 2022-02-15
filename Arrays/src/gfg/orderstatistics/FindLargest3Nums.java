package gfg.orderstatistics;

/*
Find the largest three distinct elements in an array
Difficulty Level : Easy
Given an array with all distinct elements, find the largest three elements. Expected time complexity is O(n) and extra space is O(1).
Examples :

Input: arr[] = {10, 4, 3, 50, 23, 90}
Output: 90, 50, 23
*/
public class FindLargest3Nums {
    public static void main(String[] args) {
        int[] arr = {12, 13, 1, 10, 34, 1};
        int n = arr.length;
        print3largest(arr, n);
    }

    private static void print3largest(int[] arr, int n) {
        int i, first, second, third;
        /* There should be at least three elements */
        if (n < 3) {
            System.out.print(" Invalid Input ");
            return;
        }
        third = first = second = Integer.MIN_VALUE;
        for (i = 0; i < n; i++) {
            /* If current element is greater than first*/
            if (arr[i] > first) {
                third = second;
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                /* If arr[i] is in between first and second then update second  */
                third = second;
                second = arr[i];
            } else if (arr[i] > third) {
                third = arr[i];
            }
        }

        System.out.println("Three largest elements are " + first + " " + second + " " + third);
    }

}
