package misc;

public class MaxAbsoluteDiff {
    public static void main(String[] args) {
        int[] Arr = {1, 3, -1};
        int result = maxArr(Arr);
        System.out.println(result);
    }

    public static int maxArr(int[] A) {
        // int maxSoFar = Integer.MIN_VALUE;
        // for(int i = 0 ; i < A.length ; i++) {
        //     for(int j = 0; j <= i; j++ ) { // 2 For loops so more complexity
        //         maxSoFar = Math.max(maxSoFar, Math.abs(A[i] - A[j]) + Math.abs(i - j));
        //     }
        // }
        // return maxSoFar;
        int mx1 = Integer.MIN_VALUE;
        int mx2 = Integer.MIN_VALUE;
        int mn1 = Integer.MAX_VALUE;
        int mn2 = Integer.MAX_VALUE;

        for (int i = 0; i < A.length; i++) {
            mx1 = Math.max(mx1, A[i] + i);
            mx2 = Math.max(mx2, A[i] - i);
            mn1 = Math.min(mn1, A[i] + i);
            mn2 = Math.min(mn2, A[i] - i);
        }
        return Math.max(mx1 - mn1, mx2 - mn2);
    }
}
