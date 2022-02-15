package misc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a paragraph and a list of banned words, return the most frequent word
 * that is not in the list of banned words. It is guaranteed there is at least
 * one word that isn't banned, and that the answer is unique.
 * 
 * Words in the list of banned words are given in lowercase, and free of
 * punctuation. Words in the paragraph are not case sensitive. The answer is in
 * lowercase.
 * 
 * Example:
 * 
 * Input:
 * 
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * 
 * banned = ["hit"]
 * 
 * Output: "ball"
 * 
 * Explanation: "hit" occurs 3 times, but it is a banned word. "ball" occurs
 * twice (and no other word does), so it is the most frequent non-banned word in
 * the paragraph. Note that words in the paragraph are not case sensitive, that
 * punctuation is ignored (even if adjacent to words, such as "ball,"), and that
 * "hit" isn't the answer even though it occurs more because it is banned.
 */
public class MostCommonWord {
    public static void main(String[] args) {
        // String banned[] = { "hit" };
        // System.out.println(mostCommonWord("Bob hit a ball, the hit BALL flew far
        // after it was hit.", banned));

        String banned2[] = { "abc", "abcd", "jeff" };
        System.out.println(mostCommonWord("abc abc? abcd the jeff!", banned2));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        String result = "";
        // paragraph = paragraph.toLowerCase();
        // paragraph = paragraph.replaceAll("\\!", " ");
        // paragraph = paragraph.replaceAll("\\?", " ");
        // paragraph = paragraph.replaceAll("\\'", " ");
        // paragraph = paragraph.replaceAll("\\,", " ");
        // paragraph = paragraph.replaceAll("\\;", " ");
        // paragraph = paragraph.replaceAll("\\.", " ");

        // paragraph = paragraph.replaceAll("\\ ", " ");
        // String words[] = paragraph.split(" ");

        // Alternative to above is split with "\\W+"
        String words[] = paragraph.toLowerCase().split("\\W+");

        Map<String, Integer> wordToCountMap = new HashMap<>();

        HashSet<String> h = new HashSet<>();

        for (String b : banned) {
            h.add(b);
        }

        for (String word : words) {
            if (!h.contains(word)) {
                // if (wordToCountMap.containsKey(word)) {
                // wordToCountMap.put(word, wordToCountMap.get(word) + 1);
                // } else {
                // wordToCountMap.put(word, 1);
                // }

                // Alternate to above if else is
                wordToCountMap.put(word, wordToCountMap.getOrDefault(word, 0) + 1);
            }

        }
        int count = 0;
        // for (Map.Entry<String, Integer> wordsMap : wordToCountMap.entrySet()) {
        // if (wordsMap.getValue() > count) {
        // count = wordsMap.getValue();
        // result = wordsMap.getKey();
        // }
        // }
        // Alternate (above code will take more space while the below is with less
        // space)

        for (String word : wordToCountMap.keySet()) {
            if (wordToCountMap.get(word) > count) {
                count = wordToCountMap.get(word);
                result = word;
            }
        }

        return result;
    }
}