package sorting;

/*
Shortest Un-ordered Subarray
Difficulty Level : Easy

An array is given of n length, and problem is that we have to find the length of shortest unordered
{neither increasing nor decreasing} sub array in given array.

Examples:

Input : n = 5
7 9 10 8 11
Output : 3
Explanation : 9 10 8 unordered sub array.

Input : n = 5
1 2 3 4 5
Output : 0
Explanation :  Array is in increasing order.
*/
public class ShortestUnSortedArray {
    // boolean function to check array elements
    // are in increasing order or not
    public static boolean increasing(int[] a, int n) {
        for (int i = 0; i < n - 1; i++)
            if (a[i] >= a[i + 1])
                return false;

        return true;
    }

    // boolean function to check array elements
    // are in decreasing order or not
    public static boolean decreasing(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++)
            if (arr[i] < arr[i + 1])
                return false;

        return true;
    }

    public static int shortestUnsorted(int[] a, int n) {

        // increasing and decreasing are two functions.
        // if function return true value then print
        // 0 otherwise 3.
        if (increasing(a, n) ||
                decreasing(a, n))
            return 0;
        else
            return 3;
    }

    // driver program
    public static void main(String[] args) {

        int[] ar = new int[]{7, 9, 10, 8, 11};
        int n = ar.length;

        System.out.println(shortestUnsorted(ar, n));
    }
}
