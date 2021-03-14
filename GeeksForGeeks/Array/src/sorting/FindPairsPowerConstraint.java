package sorting;

/*
Find number of pairs (x, y) in an array such that x^y > y^x
Difficulty Level : Hard

Given two arrays X[] and Y[] of positive integers,
find number of pairs such that x^y > y^x where x is an element from X[] and y is an element from Y[].

Examples:

Input: X[] = {2, 1, 6}, Y = {1, 5}
Output: 3
Explanation: There are total 3 pairs where pow(x, y) is greater
than pow(y, x) Pairs are (2, 1), (2, 5) and (6, 1)

Input: X[] = {10, 19, 18}, Y[] = {11, 15, 9}
Output: 2
Explanation: There are total 2 pairs where pow(x, y) is greater
than pow(y, x) Pairs are (10, 11) and (10, 15)
*/
public class FindPairsPowerConstraint {
    public static void main(String[] args) {
        int[] X = {2, 1, 6};
        int[] Y = {1, 5};
        System.out.println(countPairsBruteForce(X, Y, X.length, Y.length));
    }

    public static int countPairsBruteForce(int[] X, int[] Y,
                                           int m, int n) {
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.pow(X[i], Y[j]) > Math.pow(Y[j], X[i])) {
                    ans++;
                }
            }
        }

        return ans;
    }
}
