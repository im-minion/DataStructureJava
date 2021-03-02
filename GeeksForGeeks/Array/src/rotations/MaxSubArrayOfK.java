package rotations;

public class MaxSubArrayOfK {
    public static void main(String[] args) {
        int[] Arr = {1, 12, 3, 4, 10};
        int result = solve(Arr, 2);
        System.out.println(result);
    }

    public static int solve(int[] arr, int k) {
        int result = Integer.MIN_VALUE;
        int i = 0;
        int j = 0;
        int n = arr.length;
        int sum = 0;
        while (j < n) {
            sum = sum + arr[j];
            if ((j - i + 1) == k) {
                result = Math.max(result, sum);
                sum = sum - arr[i];
                i++;
                j++;
            } else {
                j++;
            }
        }

        return result;
    }
}
