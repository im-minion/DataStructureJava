package gfg.rangequeries;

/*
TODO: UTS
4. Range sum query using Sparse Table
Difficulty Level : Medium

We have an array arr[]. We need to find the sum of all the elements in the range L and R where 0 <= L <= R <= n-1.
Consider a situation when there are many range queries.
*/
public class RangeSumUsingSparseTable {
    // Because 2^17 is larger than 10^5
    static int k = 16;

    // Maximum value of array
    static int N = 100000;

    // k + 1 because we need to access table[r][k]
    static long[][] table = new long[N][k + 1];

    // it builds sparse table.
    static void buildSparseTable(int[] arr, int n) {
        for (int i = 0; i < n; i++)
            table[i][0] = arr[i];

        for (int j = 1; j <= k; j++)
            for (int i = 0; i <= n - (1 << j); i++)
                table[i][j] = table[i][j - 1] + table[i + (1 << (j - 1))][j - 1];
    }

    // Returns the sum of the elements in the range L and R.
    static long query(int L, int R) {
        // boundaries of next query, 0-indexed
        long answer = 0;
        for (int j = k; j >= 0; j--) {
            if (L + (1 << j) - 1 <= R) {
                answer = answer + table[L][j];
                // instead of having L', we increment L directly
                L += 1 << j;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 5, 8, 9};
        int n = arr.length;

        buildSparseTable(arr, n);

        System.out.println(query(0, 5));
        System.out.println(query(3, 5));
        System.out.println(query(2, 4));
    }
}
