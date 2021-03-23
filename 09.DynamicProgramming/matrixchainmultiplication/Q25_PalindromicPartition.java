package matrixchainmultiplication;

import java.util.Arrays;

/*
Palindrome Partitioning | DP-17
Difficulty Level : Hard

Given a string, a partitioning of the string is a palindrome partitioning if every substring of the partition is a palindrome.
For example, “aba|b|bbabb|a|b|aba” is a palindrome partitioning of “ababbbabbababa”.
Determine the fewest cuts needed for a palindrome partitioning of a given string.
For example, minimum of 3 cuts are needed for “ababbbabbababa”. The three cuts are “a|babbbab|b|ababa”.
If a string is a palindrome, then minimum 0 cuts are needed.
If a string of length n containing all different characters, then minimum n-1 cuts are needed.
 */
public class Q25_PalindromicPartition {
    static int[][] t;

    public static void main(String[] args) {
        String str = "ababbbabbababa";
        System.out.println("Min cuts needed for Palindrome Partitioning Recursive is " + minPalPartition(str, 0, str.length() - 1));

        t = new int[str.length()][str.length()];
        for (int[] row : t) {
            Arrays.fill(row, -1);
        }
        System.out.println("Min cuts needed for Palindrome Partitioning Memoize is " + minPalPartitionMemoize(str, 0, str.length() - 1));
    }

    private static int minPalPartitionMemoize(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j))
            return 0;
        if (t[i][j] != -1) {
            return t[i][j];
        }
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int left = t[i][k] != -1 ? t[i][k] : minPalPartitionMemoize(s, i, k);
            if (t[i][k] == -1) {
                t[i][k] = left;
            }
            int right = t[k + 1][j] != -1 ? t[k + 1][j] : minPalPartitionMemoize(s, k + 1, j);
            if (t[k + 1][j] == -1) {
                t[k + 1][j] = right;
            }
            int temp = 1 + left + right;
            min = Math.min(min, temp);
        }
        return t[i][j] = min;
    }

    private static int minPalPartition(String s, int i, int j) {
        if (i >= j || isPalindrome(s, i, j))
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            int temp = 1 + minPalPartition(s, i, k) + minPalPartition(s, k + 1, j);
            min = Math.min(min, temp);
        }
        return min;
    }

    private static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }
}
