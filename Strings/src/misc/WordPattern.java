package misc;
/**
 * 
 * Word Pattern
 * 
 * Given a pattern and a string str, find if str follows the same pattern.
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 
 * 
 * Example 1:
 * Input: pattern = "abba", str = "dog cat cat dog"
 * Output: true
 * 
 * Example 2:
 * Input:pattern = "abba", str = "dog cat cat fish"
 * Output: false
 * 
 * Example 3:
 * Input: pattern = "aaaa", str = "dog cat cat dog"
 * Output: false
 * 
 * 
 * Example 4:
 * Input: pattern = "abba", str = "dog dog dog dog"
 * Output: false
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordPattern {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog cat cat dog"));

        System.out.println(wordPattern("abba", "dog cat cat fish"));

        System.out.println(wordPattern("aaaa", "dog cat cat dog"));

        System.out.println(wordPattern("abba", "dog dog dog dog"));

    }

    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> m = new HashMap<>();
        HashSet<String> h = new HashSet<>();
        String words[] = str.split(" ");
        if (pattern.length() != words.length)
            return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (!m.containsKey(pattern.charAt(i))) {
                if (!h.contains(words[i])) {
                    m.put(pattern.charAt(i), words[i]);
                    h.add(words[i]);
                } else {
                    return false;
                }
            } else {
                if (!m.get(pattern.charAt(i)).equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}