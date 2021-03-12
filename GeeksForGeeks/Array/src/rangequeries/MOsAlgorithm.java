package rangequeries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
MO’s Algorithm (Query Square Root Decomposition) | Set 1 (Introduction)
Difficulty Level : Hard

Let us consider the following problem to understand MO’s Algorithm.
We are given an array and a set of query ranges, we are required to find the sum of every query range.

Example:

Input:
arr[]   = {1, 1, 2, 1, 3, 4, 5, 2, 8};
query[] = [0, 4], [1, 3] [2, 4]

Output:
Sum of arr[] elements in range [0, 4] is 8
Sum of arr[] elements in range [1, 3] is 4
Sum of arr[] elements in range [2, 4] is 6
*/
public class MOsAlgorithm {
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        int n = a.length;

        List<Query> q = new ArrayList<Query>();
        q.add(new Query(0, 4));
        q.add(new Query(1, 3));
        q.add(new Query(2, 4));

        int m = q.size();
        List<Integer> op = getQuerySums(a, n, q, m);
        System.out.println("Naive Approach" + op);

        op = getQuerySumsMO(a, n, q, m);
        System.out.println("MO Approach" + op);
    }

    private static List<Integer> getQuerySumsMO(int[] arr, int n, List<Query> q, int m) {
        int block = (int) Math.sqrt(n);
        List<Integer> op = new ArrayList<>();
        // Sort all queries so that queries of same blocks
        // are arranged together.
        // Function used to sort all queries so that all queries
// of the same block are arranged together and within a block,
// queries are sorted in increasing order of R values.
        q.sort((x, y) -> {

            // Different blocks, sort by block.
            if (x.L / block != y.L / block)
                return (x.L < y.L ? -1 : 1);
            // Same block, sort by R value
            return (x.R < y.R ? -1 : 1);
        });

        // Initialize current L, current R and current sum
        int currL = 0, currR = 0;
        int currSum = 0;

        // Traverse through all queries
        for (int i = 0; i < m; i++) {
            // L and R values of current range
            int L = q.get(i).L, R = q.get(i).R;

            // Remove extra elements of previous range. For
            // example if previous range is [0, 3] and current
            // range is [2, 5], then a[0] and a[1] are subtracted
            while (currL < L) {
                currSum -= arr[currL];
                currL++;
            }

            // Add Elements of current Range
            while (currL > L) {
                currSum += arr[currL - 1];
                currL--;
            }
            while (currR <= R) {
                currSum += arr[currR];
                currR++;
            }

            // Remove elements of previous range.  For example
            // when previous range is [0, 10] and current range
            // is [3, 8], then a[9] and a[10] are subtracted
            while (currR > R + 1) {
                currSum -= arr[currR - 1];
                currR--;
            }

            // Print sum of current range
            op.add(currSum);

        }
        return op;
    }

    private static List<Integer> getQuerySums(int[] arr, int n, List<Query> q, int m) {
        List<Integer> op = new ArrayList<>();
        q.forEach(query -> {
            int currSum = 0;
            for (int i = query.L; i <= query.R && i < n; i++) {
                currSum += arr[i];
            }
            op.add(currSum);
        });
        return op;
    }
}

class Query {
    int L;
    int R;

    Query(int L, int R) {
        this.L = L;
        this.R = R;
    }
}
