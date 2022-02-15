package misc;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] Arr = {1, 2, 3, 4, -10};
        int result = maxSubArray(Arr);
        System.out.println(result);
    }

    public static int maxSubArray(final int[] A) {
        int m = 0;
        int maxSoFar = Integer.MIN_VALUE;
        for (int j : A) {
            m = m + j;
            if (m < j) {
                m = j;
            }
            maxSoFar = Math.max(maxSoFar, m);
        }
        return maxSoFar;
    }
}
