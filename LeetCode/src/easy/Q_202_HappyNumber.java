package easy;

import java.util.HashSet;
import java.util.Set;
/*202. Happy Number
Solved
Easy
Topics
Companies
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.



Example 1:

Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
Example 2:

Input: n = 2
Output: false


Constraints:

1 <= n <= 231 - 1*/
public class Q_202_HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    // little faster
    public static boolean isHappy(int n) {
        if (n < 0) return false;
        if (n == 1) return true;
        int counter = 0;
        int currSum = Integer.MAX_VALUE;
        while (n <= Integer.MAX_VALUE - 1 && counter <= 100) {
            if (currSum == 1) {
                return true;
            } else {
                String s = String.valueOf(n);
                int x = s.length() - 1;
                currSum = 0;
                while (x >= 0) {
                    int digit = (s.charAt(x) - '0');
                    currSum = currSum + (digit * digit);
                    x--;
                }
                n = currSum;
            }
            counter++;
        }

        return false;
    }

    // fastest
    public static boolean isHappy2(int n) {
        if (n < 0) return false;
        Set<Integer> records = new HashSet<>();
        while (n != 1 && !records.contains(n)) {
            records.add(n);
            n = getNewN(n);
        }
        return n == 1;
    }

    private static int getNewN(int n) {
        int res = 0;
        while (n > 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }
        return res;
    }


    public boolean isHappy2PointerApproach(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = square(slow);
            fast = square(square(fast));
        } while (slow != fast);

        return slow == 1;
    }

    public int square(int n) {
        int op = 0;
        while(n > 0) {
            int rem = n%10;
            op = op + (rem*rem);
            n = n / 10;
        }
        return op;
    }
}
