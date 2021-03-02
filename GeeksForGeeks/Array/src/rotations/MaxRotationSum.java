package rotations;

import java.util.Arrays;

public class MaxRotationSum {

    public static void main(String[] args) {
        int[] arr = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int r = findMaxRotation(arr);
        int r = optimal(arr);
        System.out.println(r);
    }

    private static int optimal(int[] arr) {
        int currVal, maxVal;
        int sum = Arrays.stream(arr).sum();
        currVal = getCurrSum(arr);
        maxVal = currVal;
        int n = arr.length;

        for (int j = 1; j < n; j++) {
            currVal = currVal + sum - n * arr[n - j];
            maxVal = Math.max(currVal, maxVal);
        }
        return maxVal;
    }

    private static int findMaxRotation(int[] arr) {
        int result = Integer.MIN_VALUE;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int curSum = getCurrSum(arr);

            System.out.println("i: " + i + ", sum: " + curSum);
            result = Math.max(result, curSum);
            leftRotateByOne(arr);
        }
        return result;
    }

    private static void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        int i;
        for (i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;

    }

    private static int getCurrSum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += i * arr[i];
        }
        return sum;
    }
}
