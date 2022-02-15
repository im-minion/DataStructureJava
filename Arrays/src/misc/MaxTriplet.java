package misc;

import java.util.TreeSet;

public class MaxTriplet {

    public static void main(String[] args) {
        int[] Arr = {2, 5, 3, 1, 4, 9};
        int result = solve(Arr);
        System.out.println(result);
    }

    private static int solve(int[] A) {
        int maxSoFar = 0;
        int n = A.length;
        int[] rightMax = new int[n];
        rightMax[n - 1] = A[n - 1];
        for (int i = n - 2; i >= 0; i--) { // start from second last element to 0th
            rightMax[i] = Math.max(rightMax[i + 1], A[i]);
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(A[0]);
        for (int j = 1; j < n - 1; j++) {
            Integer lmax = treeSet.lower(A[j]);
            int rmax = rightMax[j + 1];
            if (lmax != null && A[j] < rmax) {
                maxSoFar = Math.max(maxSoFar, lmax + A[j] + rmax);
            }
            treeSet.add(A[j]);
        }
        return maxSoFar;
    }
}
