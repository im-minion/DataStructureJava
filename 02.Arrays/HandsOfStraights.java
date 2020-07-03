import java.util.TreeMap;

/**
 * Alice has a hand of cards, given as an array of integers. Return true if and
 * only if she can. Now she wants to rearrange the cards into groups so that
 * each group is size W, and consists of W consecutive cards. Input: hand =
 * [1,2,3,6,2,3,4,7,8], W = 3 Output: true Explanation: Alice's hand can be
 * rearranged as [1,2,3],[2,3,4],[6,7,8].
 * 
 * 
 * Input: hand = [1,2,3,4,5], W = 4 Output: false Explanation: Alice's hand
 * can't be rearranged into groups of 4.
 * 
 */
public class HandsOfStraights {
    public static void main(String[] args) {
        int[] data = new int[] { 1, 2, 3, 4, 5 };
        int groupSize = 4;
        boolean result = solve(data, groupSize);
        System.out.println("can arrange cards in group of 3 ? " + result);
    }

    private static boolean solve(int data[], int groupSize) {
        if (data == null || data.length == 0 || data.length % groupSize != 0)
            return false;
        TreeMap<Integer, Integer> dataCountsMap = new TreeMap<>();
        for (int number : data) {
            if (dataCountsMap.containsKey(number)) {
                dataCountsMap.replace(number, dataCountsMap.get(number) + 1);
            } else {
                dataCountsMap.put(number, 1);
            }
        }
        while (dataCountsMap.size() > 0) {
            int key = dataCountsMap.firstKey();

            for (int i = key; i < key + groupSize; i++) {
                if (!dataCountsMap.containsKey(i))
                    return false;
                int count = dataCountsMap.get(i);
                if (count == 1) {
                    dataCountsMap.remove(i);
                } else {
                    dataCountsMap.replace(i, count - 1);
                }
            }
        }
        return true;

    }

}