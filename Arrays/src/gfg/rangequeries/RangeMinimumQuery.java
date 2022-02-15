package gfg.rangequeries;

import java.util.ArrayList;
import java.util.List;

/*
5. Range Minimum Query (Square Root Decomposition and Sparse Table)
Difficulty Level : Hard

We have an array arr[0 . . . n-1]. We should be able to efficiently find the minimum value from index L (query start) to R (query end) where 0 <= L <= R <= n-1.
Consider a situation when there are many range queries.
Example:

Input:  arr[]   = {7, 2, 3, 0, 5, 10, 3, 12, 18};
query[] = [0, 4], [4, 7], [7, 8]

Output:
Minimum of [0, 4] is 0
Minimum of [4, 7] is 3
Minimum of [7, 8] is 12

A simple solution is to run a loop from L to R and find the minimum element in the given range. This solution takes O(n) time to query in the worst case.
Another approach is to use Segment tree. With segment tree, preprocessing time is O(n) and time to for range minimum query is O(Logn).
The extra space required is O(n) to store the segment tree. Segment tree allows updates also in O(Log n) time.

Can we do better if we know that the array is static?
How to optimize query time when there are no update operations and there are many range minimum queries?
Below are different methods.
Method 1 (Simple Solution)
A Simple Solution is to create a 2D array lookup[][] where an entry lookup[i][j] stores the minimum value in range arr[i..j].
The minimum of a given range can now be calculated in O(1) time.
*/
public class RangeMinimumQuery {

    static int MAX = 500;

    // lookup[i][j] is going to store index of minimum value in arr[i..j]
    static int[][] lookup = new int[MAX][MAX];

    public static void main(String[] args) {
        int[] a = {7, 2, 3, 0, 5, 10, 3, 12, 18};
        int n = a.length;
        Query[] q = {new Query(0, 4), new Query(4, 7),
                new Query(7, 8)};
        int m = q.length;
        List<Integer> op = RMQ(a, n, q, m);
        System.out.println(op);
    }

    // Prints minimum of given m query ranges in arr[0..n-1]
    static List<Integer> RMQ(int[] arr, int n, Query[] q, int m) {
        List<Integer> op = new ArrayList<>();

        // Fill lookup table for all possible input queries
        preprocess(arr, n);

        // One by one compute sum of all queries
        for (int i = 0; i < m; i++) {
            // Left and right boundaries of current range
            int L = q[i].L, R = q[i].R;

            op.add(arr[lookup[L][R]]);
        }
        return op;

    }

    // Fills lookup array lookup[n][n] for all possible values of query ranges
    static void preprocess(int[] arr, int n) {
        // Initialize lookup[][] for
        // the intervals with length 1
        for (int i = 0; i < n; i++)
            lookup[i][i] = i;

        // Fill rest of the entries in bottom up manner
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                // To find minimum of [0,4], we compare minimum of arr[lookup[0][3]] with arr[4].
                if (arr[lookup[i][j - 1]] < arr[j])
                    lookup[i][j] = lookup[i][j - 1];
                else
                    lookup[i][j] = j;
        }
    }
}
