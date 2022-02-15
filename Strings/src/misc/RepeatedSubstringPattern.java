package misc;

/**
 * 
 * Repeated Substring Pattern
 * 
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "abab" Output: True Explanation: It's the substring "ab" twice.
 * 
 * Example 2:
 * 
 * Input: "aba" Output: False
 * 
 * Example 3:
 * 
 * Input: "abcabcabcabc" Output: True Explanation: It's the substring "abc" four
 * times. (And the substring "abcabc" twice.)
 */

public class RepeatedSubstringPattern {
    public static void main(String[] args) {
        System.out.println(repeatedSubstringPattern("abab"));
        System.out.println(repeatedSubstringPattern("aba"));
        System.out.println(repeatedSubstringPattern("abcabcabcabc"));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                int repeatz = n / i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < repeatz; j++) {
                    sb.append(substring);
                }
                if (sb.toString().equals(s))
                    return true;
            }
        }
        return false;
    }
}