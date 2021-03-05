package orderstatistics;

/*
Minimum product of k integers in an array of positive Integers
Difficulty Level : Easy

Given an array of n positive integers.
We are required to write a program to print the minimum product of k integers of the given array.
Examples:


Input : 198 76 544 123 154 675
k = 2
Output : 9348
We get minimum product after multiplying
76 and 123.

Input : 11 8 5 7 5 100
k = 4
Output : 1400
*/

import java.util.PriorityQueue;

public class MinProductOfKInts {
    public static void main(String[] args) {
        int[] arr = {198, 76, 544, 123, 154, 675};
        int min = minProduct(arr, 2);
        System.out.println(min);
    }

    private static int minProduct(int[] arr, int k) {
        int n = arr.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j : arr)
            pq.add(j);
        int count = 0, ans = 1;

        while (!pq.isEmpty() && count < k) {
            ans = ans * pq.element();
            pq.remove();
            count++;
        }
        return ans;
    }
}
