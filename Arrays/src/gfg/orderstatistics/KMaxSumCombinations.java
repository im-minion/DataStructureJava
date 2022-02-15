package gfg.orderstatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
K maximum sum combinations from two arrays
Difficulty Level : Hard

Given two equally sized arrays (A, B) and N (size of both arrays).
A sum combination is made by adding one element from array A and another element of array B. Display the maximum K valid sum combinations from all the possible sum combinations.

Examples:

Input :  A[] : {3, 2}
B[] : {1, 4}
K : 2 [Number of maximum sum
combinations to be printed]
Output :
 7    // (A : 3) + (B : 4)
 6    // (A : 2) + (B : 4)

Input :  A[] : {4, 2, 5, 1}
B[] : {8, 0, 3, 5}
K : 3
Output :
13   // (A : 5) + (B : 8)
12   // (A : 4) + (B :  8)
10   // (A : 2) + (B : 8)
*/
public class KMaxSumCombinations {
    public static void main(String[] args) {
        int[] A = {4, 2, 5, 1};
        int[] B = {8, 0, 5, 3};
        int K = 3;

        // Function Call
        List<Integer> op = KMaxCombinations(A, B, K);
        System.out.println(op);
    }

    // time -> O(aLength*bLength), space -> O(n)
    private static List<Integer> KMaxCombinations(int[] a, int[] b, int k) {
        List<Integer> op = new ArrayList<>();

        //max Heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int aValue : a) {
            for (int bValue : b) {
                pq.add(aValue + bValue);
            }
        }
        while (k != 0) {
            op.add(pq.peek());
            pq.remove();
            k--;
        }
        return op;
    }
}
