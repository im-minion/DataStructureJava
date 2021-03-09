package searching;

/*
Maximum Subarray Sum Excluding Certain Elements
Difficulty Level : Easy

Given an array of A of n integers and an array B of m integers find the Maximum Contiguous Subarray Sum of array A
such that any element of array B is not present in that subarray.

Examples :

Input : A = {1, 7, -10, 6, 2}, B = {5, 6, 7, 1}
Output : 2
Explanation Since the Maximum Sum Subarray of A is not allowed to have any element that is present in array B.
The Maximum Sum Subarray satisfying this is {2} as the only allowed subarrays are:{-10} and {2}.
The Maximum Sum Subarray being {2} which sums to 2

Input : A = {3, 4, 5, -4, 6}, B = {1, 8, 5}
Output : 7
Explanation
The Maximum Sum Subarray satisfying this is {3, 4} as the only allowed subarrays are
{3}, {4}, {3, 4}, {-4}, {6}, {-4, 6}. The Maximum Sum subarray being {3, 4} which sums to 7
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class MaxSubArraySumExcludeSomeElement {
    public static void main(String[] args) {
        int[] A = {1, 7, -10, 6, 2};
        int[] B = {5, 6, 7, 1};

        int n = A.length;
        int m = B.length;

        // Function call
        int sum = findMaxSubarraySum(A, B, n, m);
        System.out.println(sum);
    }

    private static int findMaxSubarraySum(int[] a, int[] b, int n, int m) {
        int sum = 0;
        HashSet<Integer> exclusions = (HashSet<Integer>) Arrays.stream(b).boxed().collect(Collectors.toSet());
        int currSum = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (exclusions.contains(a[i])) {
                currSum = 0;
            } else {
                currSum += a[i];
                currSum = Math.max(currSum, a[i]);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        return maxSum;
    }
}
