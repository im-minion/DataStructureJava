package misc;

public class MaxPlusMin {
    public static void main(String[] args) {
        int[] Arr = {-2, 1, -4, 5, 3};
        int result = solve(Arr);
        System.out.println(result);
    }

    public static int solve(int[] A) {
        int maxSoFar = Integer.MIN_VALUE;
        int minSoFar = Integer.MAX_VALUE;
        for (int j : A) {
            maxSoFar = Math.max(maxSoFar, j);
            minSoFar = Math.min(minSoFar, j);
        }
        return maxSoFar + minSoFar;
    }
}
