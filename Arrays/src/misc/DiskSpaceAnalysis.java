package misc;

public class DiskSpaceAnalysis {
    public static void main(String[] args) {
        int[] sp = {2, 2, 2, 2};
        // 8 2 => 2
        // 2 4 => 2
        // 4 6 => 4
        // op => 4
        System.out.println(segment(2, sp));
    }

    public static int segment(int x, int[] space) {
        int i = 0;
        int j = 0;
        int n = space.length;
        int currMin = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;
        while (j < n) { // n times
            currMin = Math.min(currMin, space[j]);
            if ((j - i + 1) == x) {
                result = Math.max(currMin, result);
                if (space[i] == currMin) {
                    i++;
                    j++;
                    currMin = getMinFromItoJ(i, j, space);
                } else {
                    i++;
                    j++;
                }
            } else {
                j++;
            }
        }
        return result;
    }

    private static int getMinFromItoJ(int i, int j, int[] space) {
        int min = Integer.MAX_VALUE;
        for (int x = i; x < j; x++) { // k times
            min = Math.min(min, space[x]);
        }
        return min;
    }
}
