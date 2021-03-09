package orderstatistics;

import java.util.*;

/*
Find k pairs with smallest sums in two arrays
Difficulty Level : Hard

Given two integer arrays arr1[] and arr2[] sorted in ascending order and an integer k.
Find k pairs with smallest sums such that one element of a pair belongs to arr1[] and other element belongs to arr2[]

Examples:

Input :
arr1[] = {1, 7, 11}
arr2[] = {2, 4, 6}
k = 3

Output :
[1, 2],
[1, 4],
[1, 6]
Explanation: The first 3 pairs are returned
from the sequence [1, 2], [1, 4], [1, 6], [7, 2], [7, 4], [11, 2], [7, 6], [11, 4], [11, 6]
*/
public class KPairsWithSmallestSum {
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 11};
        int n1 = arr1.length;

        int[] arr2 = {2, 4, 8};
        int n2 = arr2.length;

        // op => (1, 2) (1, 4) (3, 2) (3, 4)

        int k = 4;

        List<Pair> op = kSmallestPairs(arr1, n1, arr2, n2, k);
        op.stream().forEach(p -> System.out.println(p.f + " " + p.s));
    }

    private static List<Pair> kSmallestPairs(int[] arr1, int n1, int[] arr2, int n2, int k) {
        List<Pair> allPairsSorted = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                Pair t = new Pair();
                t.f = arr1[i];
                t.s = arr2[j];
                allPairsSorted.add(t);
            }
        }
        Collections.sort(allPairsSorted);
        List<Pair> op = new ArrayList<>();
        while (k > 0) {
            k--;
            op.add(allPairsSorted.get(k));
        }
        return op;
    }
}

class Pair implements Comparable {
    public int f;
    public int s;


    @Override
    public int compareTo(Object o) {
        Pair currPair;
        if (!(o instanceof Pair)) {
            return 0;
        } else {
            currPair = (Pair) o;
        }
        return Integer.compare((this.f + this.s), (currPair.f + currPair.s));
    }
}
