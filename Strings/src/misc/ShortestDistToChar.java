package misc;

/**
 * 
 * Shortest Distance to a Character
 * 
 * 
 * Given a string S and a character C, return an array of integers representing
 * the shortest distance from the character C in the string.
 * 
 * Example 1:
 * 
 * Input: S = "loveleetcode", C = 'e'
 * 
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 */
public class ShortestDistToChar {
    public static void main(String[] args) {
        for (int i : shortestToChar("loveleetcode", 'e')) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i : shortestToChar("aaba", 'b')) {
            System.out.print(i + " ");
        }
    }

    public static int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];

        int lastC = -S.length();

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == C) {
                lastC = i;
            }
            result[i] = i - lastC;
        }
        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == C) {
                lastC = i;
            }
            result[i] = Math.min(result[i], Math.abs(i - lastC));
        }
        return result;
    }

}