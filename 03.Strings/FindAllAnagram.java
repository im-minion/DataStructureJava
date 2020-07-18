import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Find All Anagrams in a String
 * 
 * 
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * Example 1:
 * 
 * Input: s: "cbaebabacd" p: "abc"
 * 
 * Output: [0, 6]
 * 
 * Explanation: The substring with start index = 0 is "cba", which is an anagram
 * of "abc". The substring with start index = 6 is "bac", which is an anagram of
 * "abc".
 * 
 * Example 2:
 * 
 * Input: s: "abab" p: "ab"
 * 
 * Output: [0, 1, 2]
 * 
 * Explanation: The substring with start index = 0 is "ab", which is an anagram
 * of "ab". The substring with start index = 1 is "ba", which is an anagram of
 * "ab". The substring with start index = 2 is "ab", which is an anagram of
 * "ab".
 */
public class FindAllAnagram {
    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0)
            return result;

        int char_count[] = new int[26];

        for (char c : p.toCharArray()) {
            char_count[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        while (right < s.length()) {
            if (char_count[s.charAt(right++) - 'a']-- >= 1)
                count--;

            if (count == 0)
                result.add(left);

            if (right - left == p.length() && char_count[s.charAt(left++) - 'a']++ >= 0)
                count++;
        }

        return result;
    }
}