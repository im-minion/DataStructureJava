package orderstatistics;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
K-th Largest Sum Contiguous Subarray
Difficulty Level : Medium

Given an array of integers.
Write a program to find the K-th largest sum of contiguous subarray within the array of numbers which has negative and positive numbers.
Examples:


Input: a[] = {20, -5, -1}
k = 3
Output: 14
Explanation: All sum of contiguous subarrays are (20, 15, 14, -5, -6, -1) so the 3rd largest sum is 14.

Input: a[] = {10, -10, 20, -40}
k = 6
Output: -10
Explanation: The 6th largest sum among sum of all contiguous subarrays is -10.
*/
public class KthLargestSumSubArray {
    public static void main(String[] args) {
        int[] arr = {20, -5, -1};
        int min = KthMinSubarraySum(arr, 3);
        System.out.println(min);
    }

    private static int KthMinSubarraySum(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] sum = new int[n + 1];
        sum[0] = 0;
        sum[1] = sum[1 - 1] + arr[0];
        for (int i = 2; i <= n; i++) {
            sum[i] = sum[i - 1] + arr[i - 1];
        }
        Arrays.stream(sum).forEach(el -> System.out.print(el + " "));
        System.out.println();
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                // sum from index i to j is =>
                int x = sum[j] - sum[i - 1];
                if (pq.size() < k) {
                    pq.add(x);
                } else {
                    if (pq.peek() < x) {
                        pq.poll();
                        pq.add(x);
                    }
                }
            }
        }

        return pq.poll();
    }
}
