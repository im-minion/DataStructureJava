package gfg.rearrange;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0};
        //     op => 1  9  8  4  2  7  6  0  0  0  0
        reArrangeWithSingleTraversal(arr);
        Arrays.stream(arr).forEach(System.out::print);
    }

    // o(n) , while loop is twice
    private static void reArrange(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        while (i < n) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                j++;
            }
            i++;
        }
        while (j < n) {
            arr[j] = 0;
            j++;
        }
    }

    // o(n) , single traversal;
    private static void reArrangeWithSingleTraversal(int[] arr) {
        int n = arr.length;
        int i = 0;
        int lastNonZeroIndex = -1;

        while (i < n) {
            if (arr[i] != 0) {
                if(i != lastNonZeroIndex) {
                    lastNonZeroIndex++;
                    int t = arr[lastNonZeroIndex];
                    arr[lastNonZeroIndex] = arr[i];
                    arr[i] = t;
                }
            }
            i++;
        }

    }
}
