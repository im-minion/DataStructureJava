package misc;

/**
 * 
 * Given a string s and a string t, check if s is subsequence of t.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ace" is a
 * subsequence of "abcde" while "aec" is not).
 * 
 * Follow up: If there are lots of incoming S, say S1, S2, ... , Sk where k >=
 * 1B, and you want to check one by one to see if T has its subsequence. In this
 * scenario, how would you change your code?
 * 
 * Credits: Special thanks to @pbrother for adding this problem and creating all
 * test cases.
 * 
 * Example 1: Input: s = "abc", t = "ahbgdc" Output: true
 * 
 * Example 2: Input: s = "axc", t = "ahbgdc" Output: false
 */

public class SubSequence {
    public static void main(String[] args) {
        System.out.println(isSubSequence("abgdc", "ahbgdc"));
        System.out.println(isSubSequence("axc", "ahbgdc"));
    }

    private static boolean isSubSequence(String S, String T) {
        if (S == null || T == null || S.length() == 0 || T.length() == 0 || S.equals(T))
            return true;

        if (S.length() > T.length())
            return false;

        int sPointer = 0;
        // int tPointer = 0;
        for (int i = 0; i < T.length(); i++) {
            if (S.charAt(sPointer) == T.charAt(i)) {
                sPointer++;
            }
            if (sPointer == S.length()) {
                return true;
            }
        }
        return false;
    }
}