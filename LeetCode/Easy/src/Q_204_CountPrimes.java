/*
Count the number of prime numbers less than a non-negative number, n.

* Example 1:
Input: n = 10
Output: 4
Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.

* Example 2:
Input: n = 0
Output: 0

* Example 3:
Input: n = 1
Output: 0

Constraints:
0 <= n <= 5 * 106
*/

import java.util.Arrays;

public class Q_204_CountPrimes {
    public static void main(String[] args) {
        System.out.println(countPrimes(10));
    }

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        int count = 0;
        for (int i = 2; i < n; i++) {
            // if i == prime increment count and make ith true;
            if (isPrime[i]) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return count;
    }
}
