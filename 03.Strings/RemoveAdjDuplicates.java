/**
 * 
 * Remove All Adjacent Duplicates In String
 * 
 * Given a string S of lowercase letters, a duplicate removal consists of
 * choosing two adjacent and equal letters, and removing them.
 * 
 * We repeatedly make duplicate removals on S until we no longer can.
 * 
 * Return the final string after all such duplicate removals have been made. It
 * is guaranteed the answer is unique.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "abbaca" Output: "ca"
 * 
 * Explanation: For example, in "abbaca" we could remove "bb" since the letters
 * are adjacent and equal, and this is the only possible move. The result of
 * this move is that the string is "aaca", of which only "aa" is possible, so
 * the final string is "ca".
 */
public class RemoveAdjDuplicates {
    public static void main(String[] args) {
        String output = removeDuplicates("abbaca");
        System.out.println(output);

        System.out.println(removeDuplicates("S"));
    }

    public static String removeDuplicates(String S) {
        char[] stack = new char[S.length()];
        int counter = 0;
        for (int i = 0; i < S.length(); i++) {
            char currentChar = S.charAt(i);
            if (counter > 0 && currentChar == stack[counter - 1]) {
                counter--;
            } else {
                stack[counter] = currentChar;
                counter++;
            }
        }

        return new String(stack, 0, counter);
    }
}