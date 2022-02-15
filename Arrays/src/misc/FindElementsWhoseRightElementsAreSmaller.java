package misc;

import java.util.ArrayList;
import java.util.List;

public class FindElementsWhoseRightElementsAreSmaller {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 2, 6, 7, 5};
        List<Integer> list = solve(arr);
        System.out.println(list);
    }

    private static List<Integer> solve(int[] arr) {
        List<Integer> op = new ArrayList<>();
        int n = arr.length - 1;
        int tillMax = arr[n];
        op.add(tillMax);
        for (int i = n; i >= 0; i--) {
            if (arr[i] > tillMax) {
                op.add(arr[i]);
            }
            tillMax = Math.max(arr[i], tillMax);
        }
        return op;
    }
}
