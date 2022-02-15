package misc;

/**
 * Valid Anagram Given two strings s and t , write a function to determine if t
 * is an anagram of s.
 * 
 * Example 1:
 * 
 * Input: s = "anagram", t = "nagaram" Output: true Example 2:
 * 
 * Input: s = "rat", t = "car" Output: false
 */
public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}