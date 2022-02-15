package dp.misc;

import java.util.ArrayList;
import java.util.List;
/*

Input: a[] = {1, 2, 1}
Output: 1
Explanation:
For position 1: a[1] = 1, range = 1 to 2
For position 2: a[2] = 2, range = 1 to 3
For position 3: a[3] = 1, range = 2 to 3
Therefore, the fountain at position a[2] covers the whole garden.
Therefore, the required output is 1.
Input: a[] = {2, 1, 1, 2, 1}
Output: 2

https://www.geeksforgeeks.org/count-minimum-number-of-fountains-to-be-activated-to-cover-the-entire-garden/
 */

public class ActiveFountain {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(2);
        a.add(1);
        System.out.println(fountainActivation(a));
    }

    public static int fountainActivation(List<Integer> locations) {
        // Write your code here
        int n = locations.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1; //at least one
        }
        int leftIndex;
        int rightIndex;
        for (int i = 0; i < n; i++) {
            leftIndex = Math.max(i - locations.get(i), 0);
            rightIndex = Math.min(i + locations.get(i) + 1, n);
            dp[leftIndex] = Math.max(dp[leftIndex], rightIndex);
        }

        int count = 1;
        int nextIndex = 0;
        rightIndex = dp[0]; // inz value
        for (int i = 0; i < n; i++) {
            nextIndex = Math.max(nextIndex, dp[i]);

            if (i == rightIndex) {
                count++;
                rightIndex = nextIndex;
            }
        }

        return count;
    }
}
