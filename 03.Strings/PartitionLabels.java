
/**
 *  Partition Labels
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * 
 * Example 1: Input: S = "ababcbacadefegdehijhklij" Output: [9,7,8]
 * 
 * Explanation
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class PartitionLabels {
    public static void main(String[] args) {
        List<Integer> output = getPartitions("ababcbacadefegdehijhklij");
        Consumer<Integer> consumer = System.out::println;
        output.forEach(consumer::accept);
    }

    private static List<Integer> getPartitions(String S) {
        List<Integer> output = new ArrayList<>();
        int[] lastIndexes = new int[26];
        for (int i = 0; i < S.length(); i++) {
            lastIndexes[S.charAt(i) - 'a'] = i;
        }
        int start =0;
        int end = 0;

        for (int i = 0; i < S.length(); i++) {
            end = Math.max(end, lastIndexes[S.charAt(i) - 'a']);
            if(end == i) {
                output.add(end- start + 1);
                start = end + 1;
            }
        }
        return output;
    }
}