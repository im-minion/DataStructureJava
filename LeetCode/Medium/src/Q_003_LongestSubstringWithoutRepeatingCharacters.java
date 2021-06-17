/*
3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Example 4:

Input: s = ""
Output: 0
* */

import java.util.HashSet;
import java.util.Set;

public class Q_003_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        int n = s.length();
        int op = 0;
        while (j < n) {
            while (i != j && set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            op = Math.max(op, j - i + 1);
            set.add(s.charAt(j));
            j++;
        }
        return op;
    }
}
