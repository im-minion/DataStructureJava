package misc;
/**
 * Given an array A of strings made only from lowercase letters, return a list
 * of all characters that show up in all strings within the list (including
 * duplicates). For example, if a character occurs 3 times in all strings but
 * not 4 times, you need to include that character three times in the final
 * answer.
 * 
 * You may return the answer in any order.
 * 
 * Example 1: Input: ["bella","label","roller"] Output: ["e","l","l"]
 * 
 * Example 2: Input: ["cool","lock","cook"] Output: ["c","o"]
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommonCharacters {

    public static void main(String[] args) {
        String[] input = new String[] { "bella", "label", "roller" };
        List<String> commonChars = findCommonCharacters(input);
        for (String ch : commonChars) {
            System.out.print(ch + " ");
        }
    }

    private static List<String> findCommonCharacters(String[] A) {
        List<String> commonChars = new ArrayList<>();
        int minFrequencies[] = new int[26];
        Arrays.fill(minFrequencies, Integer.MAX_VALUE);
        for (String currentString : A) {
            int charFrequencies[] = new int[26];

            for (char c : currentString.toCharArray()) {
                charFrequencies[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFrequencies[i] = Math.min(minFrequencies[i], charFrequencies[i]);
            }
        }
        for (int i = 0; i < 26; i++) {
            while (minFrequencies[i] > 0) {
                commonChars.add("" + (char) (i + 'a'));
                minFrequencies[i]--;
            }
        }
        return commonChars;
    }
}