package misc;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 */
public class LengthOfLongestPalindrome {
    public static void main(String[] args) {
        System.out.println(getLengthOfLongestPalindrome("abccccdd"));
    }

    private static int getLengthOfLongestPalindrome(String input) {
        int count = 0;
        HashMap<Character, Integer> charToCountMap = new HashMap<>();
        for (Character c : input.toCharArray()) {
            if (charToCountMap.containsKey(c)) {
                charToCountMap.put(c, charToCountMap.get(c) + 1);
            } else {
                charToCountMap.put(c, 1);
            }
        }
        int isOdd = 0;
        for (Map.Entry<Character, Integer> entry : charToCountMap.entrySet()) {
            count = count + entry.getValue() / 2 * 2;
            if (isOdd == 0 && entry.getValue() % 2 != 0) {
                isOdd += 1;
            }
        }

        return count + isOdd;
    }
}