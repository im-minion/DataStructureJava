/*
5. Longest Palindromic Substring
Given a string s, return the longest palindromic substring in s.



Example 1:

Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
Example 3:

Input: s = "a"
Output: "a"
Example 4:

Input: s = "ac"
Output: "a"

*/
public class Q_005_LongestPalindromicSubstring {

    public static void main(String[] args) {

    }

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        String op = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            // center i
            String temp = helper(s, i, i);
            if (temp.length() > op.length()) {
                op = temp;
            }

            // center i and i+1
            temp = helper(s, i, i + 1);
            if (temp.length() > op.length()) {
                op = temp;
            }
        }

        return op;
    }

    public String helper(String s, int center1, int center2) {
        while (center1 >= 0 && center2 < s.length() && s.charAt(center1) == s.charAt(center2)) {
            center1--;
            center2++;
        }
        return s.substring(center1 + 1, center2);
    }
}
