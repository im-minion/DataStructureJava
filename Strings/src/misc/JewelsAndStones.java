package misc;

/**
 * You're given strings J representing the types of stones that are jewels, and
 * S representing the stones you have. Each character in S is a type of stone
 * you have. You want to know how many of the stones you have are also jewels.
 * 
 * The letters in J are guaranteed distinct, and all characters in J and S are
 * letters. Letters are case sensitive, so "a" is considered a different type of
 * stone from "A".
 * 
 * Example 1: Input: J = "aA", S = "aAAbbbb" Output: 3
 * 
 * Example 2: Input: J = "z", S = "ZZ" Output: 0
 */

public class JewelsAndStones {
    public static void main(String[] args) {
        String jewels = "aA";
        String stones = "aAAbbbb";
        int count = countStonesWhichAreAlsoJewels(jewels, stones);
        System.out.println("stones which are also jewels are " + count);
    }

    private static int countStonesWhichAreAlsoJewels(String jewels, String stones) {
        if (stones == null || jewels == null || stones.isEmpty() || jewels.isEmpty())
            return 0;
        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) >= 0) { //it returns -1 if jewels doesn't include the stones.charAt(i)
                count++;
            }
        }
        return count;
    }
}