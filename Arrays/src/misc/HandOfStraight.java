package misc;
/**
 * Hand of Straights Medium
 * 
 * 775
 * 
 * 85
 * 
 * Add to List
 * 
 * Share Alice has a hand of cards, given as an array of integers.
 * 
 * Now she wants to rearrange the cards into groups so that each group is size
 * W, and consists of W consecutive cards.
 * 
 * Return true if and only if she can.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: hand = [1,2,3,6,2,3,4,7,8], W = 3 Output: true Explanation: Alice's
 * hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]. 
 * 
 * Example 2:
 * 
 * Input: hand = [1,2,3,4,5], W = 4 Output: false Explanation: Alice's hand
 * can't be rearranged into groups of 4.
 */

import java.util.TreeMap;

public class HandOfStraight {
    public static boolean isNStraightHand(int[] data, int groupSize) {
        if (data == null || data.length == 0 || groupSize < 1)
            return false;
        TreeMap<Integer, Integer> countsMap = new TreeMap<>();
        // Go through each element and add the element to count map with it's count.
        for (int i = 0; i < data.length; i++) {

            if (countsMap.containsKey(data[i])) {
                countsMap.replace(data[i], countsMap.get(data[i]) + 1);
            } else {
                countsMap.put(data[i], 1);
            }

        }

        while (countsMap.size() > 0) {
            int key = countsMap.firstKey();
            for (int i = key; i < key + groupSize; i++) {

                if (!countsMap.containsKey(i))
                    return false;

                if (countsMap.get(i) == 1) {
                    countsMap.remove(i);
                } else {
                    countsMap.replace(i, countsMap.get(i) - 1);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] data = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
        boolean result = isNStraightHand(data, 3);
        System.out.println(result);
    }
}
