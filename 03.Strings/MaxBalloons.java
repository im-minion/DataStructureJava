import java.util.HashMap;
import java.util.Map;

/**
 * Maximum Number of Balloons Easy
 * 
 * Given a string text, you want to use the characters of text to form as many
 * instances of the word "balloon" as possible.
 * 
 * You can use each character in text at most once. Return the maximum number of
 * instances that can be formed.
 * 
 * 
 * 
 * Example 1: Input: text = "nlaebolko" Output: 1
 * 
 * 
 * Example 2: Input: text = "loonbalxballpoon" Output: 2
 * 
 * Example 3: Input: text = "leetcode" Output: 0
 */
public class MaxBalloons {
    public static void main(String[] args) {
        System.out.println(getMaxBalloonsPossible("nlaebolko"));
        System.out.println(getMaxBalloonsPossible("loonbalxballpoon"));
        System.out.println(getMaxBalloonsPossible("leetcode"));

        System.out.println(getMaxBalloonsPossibleBetter("nlaebolko"));
        System.out.println(getMaxBalloonsPossibleBetter("loonbalxballpoon"));
        System.out.println(getMaxBalloonsPossibleBetter("leetcode"));
    }

    private static int getMaxBalloonsPossible(String S) {
        int count = Integer.MAX_VALUE;
        String balloon = "balloon";
        Map<Character, Integer> chatToCountMap = new HashMap<>();
        for (Character c : S.toCharArray()) {
            if (chatToCountMap.containsKey(c)) {
                chatToCountMap.put(c, chatToCountMap.get(c) + 1);
            } else {
                chatToCountMap.put(c, 1);
            }
        }
        int lCount = chatToCountMap.get('l') != null ? chatToCountMap.get('l') : 0;
        int oCount = chatToCountMap.get('o') != null ? chatToCountMap.get('o') : 0;
        if (lCount < 2) {
            return 0;
        } else {
            chatToCountMap.put('l', lCount / 2);
        }

        if (oCount < 2) {
            return 0;
        } else {
            chatToCountMap.put('o', oCount / 2);
        }
        for (Character c : balloon.toCharArray()) {
            if (chatToCountMap.get(c) != null) {
                count = Math.min(chatToCountMap.get(c), count);
            } else {
                return 0;
            }
        }
        return count;
    }

    private static int getMaxBalloonsPossibleBetter(String S) {
        int count[] = new int[26]; // all lower letter
        for (int i = 0; i < S.length(); i++) {
            count[S.charAt(i) - 'a']++;
        }
        // ASCII b=1 a=0 l=11 o=14 n=134
        int min = count[1]; // b
        min = Math.min(min, count[0]); // a
        min = Math.min(min, count[11] / 2); // l
        min = Math.min(min, count[14] / 2); // o
        min = Math.min(min, count[13]); // n

        return min;
    }

}