package gfg.orderstatistics;

import java.util.*;

/*
Find k numbers with most occurrences in the given array
Difficulty Level : Medium
Given an array of n numbers and a positive integer k.
The problem is to find k numbers with most occurrences, i.e., the top k numbers having the maximum frequency.
If two numbers have the same frequency then the larger number should be given preference.
The numbers should be displayed in decreasing order of their frequencies.
It is assumed that the array consists of k numbers with most occurrences.

Examples:

Input:
arr[] = {3, 1, 4, 4, 5, 2, 6, 1},
k = 2
Output: 4 1
Explanation:
Frequency of 4 = 2
Frequency of 1 = 2
These two have the maximum frequency and
4 is larger than 1.

Input :
arr[] = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9},
k = 4
Output: 5 11 7 10
Explanation:
Frequency of 5 = 3
Frequency of 11 = 2
Frequency of 7 = 2
Frequency of 10 = 1
These four have the maximum frequency and
5 is largest among rest.
*/
public class KNumsWithMostOccurrence {
    public static void main(String[] args) {

        int[] arr = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
        int n = arr.length;
        int k = 4;

        // Function call
        List<Integer> op = print_N_mostFrequentNumber(arr, n, k);
        System.out.println(op);
    }

    private static List<Integer> print_N_mostFrequentNumber(int[] arr, int n, int k) {
        // space -> O(k)
        List<Integer> op = new ArrayList<>();

        // space -> O(n)
        Map<Integer, Integer> mp = new HashMap<>();

        // time -> O(n)
        for (int i = 0; i < n; i++) {
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }

        // space -> O(n)
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
                (a, b) -> a.getValue().equals(b.getValue()) ?
                        Integer.compare(b.getKey(), a.getKey())
                        : Integer.compare(b.getValue(), a.getValue()));
        pq.addAll(mp.entrySet());

        // time -> O(n)
        for (int i = 0; i < k; i++) {
            op.add(Objects.requireNonNull(pq.poll()).getKey());
        }
        return op;
    }
}
