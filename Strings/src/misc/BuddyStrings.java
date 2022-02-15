package misc;
/**
 * 
 * Given two strings A and B of lowercase letters, return true if and only if we
 * can swap two letters in A so that the result equals B.
 * 
 * Example 1: Input: A = "ab", B = "ba" Output: true
 * 
 * Example 2: Input: A = "ab", B = "ab" Output: false
 * 
 * Example 3: Input: A = "aa", B = "aa" Output: true
 * 
 * Example 4: Input: A = "aaaaaaabc", B = "aaaaaaacb" Output: true
 * 
 * Example 5: Input: A = "", B = "aa" Output: false
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BuddyStrings {
    public static void main(String[] args) {

        boolean result2 = buddyString("ab", "ba");
        System.out.println(result2);

        boolean result3 = buddyString("ab", "ab");
        System.out.println(result3);

        boolean result5 = buddyString("aa", "aa");
        System.out.println(result5);

        boolean result = buddyString("aaaabc", "aaaacb");
        System.out.println(result);

        boolean result4 = buddyString("", "aa");
        System.out.println(result4);

    }

    private static boolean buddyString(String A, String B) {
        if (A.length() != B.length())
            return false;
        if (A.equals(B)) {
            HashSet<Character> chars = new HashSet<>();
            for (char c : A.toCharArray()) {
                chars.add(c);
            }
            if (chars.size() < A.length()) {
                return true;
            } else {
                return false;
            }
        }
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diff.add(i);
            }
        }
        if (diff.size() == 2 && (A.charAt(diff.get(0)) == B.charAt(diff.get(1)))
                && (A.charAt(diff.get(1)) == B.charAt(diff.get(0)))) {
            return true;
        } else {
            return false;
        }
    }
}