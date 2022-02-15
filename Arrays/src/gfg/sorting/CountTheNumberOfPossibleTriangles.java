package gfg.sorting;

import java.util.Arrays;

/*
Count the number of possible triangles
Difficulty Level : Medium

Given an unsorted array of positive integers,
find the number of triangles that can be formed with three different array elements as three sides of triangles.
 For a triangle to be possible from 3 values,
 the sum of any of the two values (or sides) must be greater than the third value (or third side).
Examples:

Input: arr= {4, 6, 3, 7}
Output: 3
Explanation:
There are three triangles
possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}.
Note that {3, 4, 7} is not a possible triangle.

Input: arr= {10, 21, 22, 100, 101, 200, 300}.
Output: 6

Explanation:
There can be 6 possible triangles:
{10, 21, 22}, {21, 100, 101}, {22, 100, 101},
{10, 100, 101}, {100, 101, 200} and {101, 200, 300}
*/
public class CountTheNumberOfPossibleTriangles {
    public static void main(String[] args) {
        int[] arr = {10, 21, 22, 100, 101, 200, 300};
        int size = arr.length;

        System.out.println("Approach 1: Total number of triangles possible is " + findNumberOfTriangles(arr, size));
        System.out.println("Approach 2: Total number of triangles possible is " + findNumberOfTriangles2(arr, size));
    }

    private static int findNumberOfTriangles(int[] arr, int n) {
        // Count of triangles
        int count = 0;

        // The three loops select three
        // different values from array
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                // The innermost loop checks for
                // the triangle property
                for (int k = j + 1; k < n; k++)

                    // Sum of two sides is greater
                    // than the third
                    if (
                            arr[i] + arr[j] > arr[k]
                                    && arr[i] + arr[k] > arr[j]
                                    && arr[k] + arr[j] > arr[i])
                        count++;
            }
        }
        return count;
    }


    // TODO: little difficult
    private static int findNumberOfTriangles2(int[] arr, int n) {
        // Count of triangles
        int count = 0;

        // Fix the first element. We need to run till n-3 as the other two elements are selected from arr[i+1...n-1]
        for (int i = 0; i < n - 2; i++) {
            // Initialize index of the rightmost third element
            int k = i + 2;
            for (int j = i + 1; j < n; j++) {
                while (k < n && arr[i] + arr[j] > arr[k])
                    ++k;

                if (k > j)
                    count += k - j - 1;
            }
        }
        return count;
    }
}
