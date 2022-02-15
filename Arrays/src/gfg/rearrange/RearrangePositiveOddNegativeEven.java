package gfg.rearrange;
/*
    Positive elements at odd and negative at even positions (Relative order not maintained)
    Difficulty Level : Medium

    Examples:

    Input : arr[] = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10}
    Output : arr[] = {1, -3, 5, -3, 6, 6, 7, -4, 9, 10}

    Input : arr[] = {-1, 3, -5, 6, 3, 6, -7, -4, -9, 10}
    Output : arr[] = {3, -1, 6, -5, 3, -7, 6, -4, 10, -9}
*/

import java.util.Arrays;

public class RearrangePositiveOddNegativeEven {
    public static void main(String[] args) {
        int[] arr = {1, -3, 5, 6, -3, 6, 7, -4, 9, 10};
        reArrange(arr);
        Arrays.stream(arr).boxed().forEach(System.out::print);
    }

    private static void reArrange(int[] arr) {
        int n = arr.length;
        int positive = 0;
        int negative = 1;

        while (true) {
            while (positive < n && arr[positive] >= 0)
                positive += 2;

            /* Move forward the negative pointer till  positive number number not encountered */
            while (negative < n && arr[negative] <= 0)
                negative += 2;

            // Swap array elements to fix their position.
            if (positive < n && negative < n) {
                int temp = arr[positive];
                arr[positive] = arr[negative];
                arr[negative] = temp;
            }

            /* Break from the while loop when any index  exceeds the size of the array */
            else
                break;
        }
    }

}
