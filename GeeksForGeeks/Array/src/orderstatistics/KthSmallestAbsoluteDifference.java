package orderstatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
k-th smallest absolute difference of two elements in an array
Difficulty Level : Hard

We are given an array of size n containing positive integers. The absolute difference between values at indices i and j is |a[i] – a[j]|. There are n*(n-1)/2 such pairs and we are asked to print the kth (1 <= k <= n*(n-1)/2) the smallest absolute difference among all these pairs.
Examples:

Input  : a[] = {1, 2, 3, 4}
k = 3
Output : 1
The possible absolute differences are :
{1, 2, 3, 1, 2, 1}.
The 3rd smallest value among these is 1.

Input : n = 2
a[] = {10, 10}
k = 1
Output : 0
*/
public class KthSmallestAbsoluteDifference {
    public static void main(String[] args) {
        int k = 1;
        int a[] = {10, 10};
        int n = a.length;
        int out = kthDiff(a, n, k);
        System.out.println(out);
    }

    private static int kthDiff(int[] arr, int n, int k) {
        List<Integer> diffs = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                diffs.add(Math.abs(arr[i] - arr[j]));
            }
        }
        Collections.sort(diffs);
//        if (diffs.size() > k - 1)
        return diffs.get(k - 1);
//        else {

//        }
    }
}
