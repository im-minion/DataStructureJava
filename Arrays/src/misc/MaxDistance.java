package misc;/*
 * Problem Description
 * Given an array A of integers, find the maximum of j - i subjected to the constraint of A[i] <= A[j].
 *
 * Input Format
 * First and only argument is an integer array A.
 *
 * Output Format
 * Return an integer denoting the maximum value of j - i;
 *
 * Input => A = [3, 5, 4, 2]
 * Output => 2
 * Maximum value occurs for pair (3, 4).
 * */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxDistance {

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(5);
        input.add(4);
        input.add(2);
        int res = MaxDistance(input);
        System.out.println(res);
    }

    public static int MaxDistance(final List<Integer> A) {
        Pair[] P = new Pair[A.size()];
        for (int i = 0; i < A.size(); i++) {
            P[i] = new Pair(A.get(i), i);
        }
        Arrays.sort(P);
        int currMin = P[0].idx, res = 0;
        for (int i = 1; i < P.length; i++) {
            res = Math.max(res, P[i].idx - currMin);
            currMin = Math.min(currMin, P[i].idx);
        }
        return res;
    }

    static class Pair implements Comparable<Pair> {
        int val, idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        public int compareTo(Pair p) {
            return this.val - p.val;
        }
    }
}


