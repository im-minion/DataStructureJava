package binarysearchtree;

import java.util.Stack;

// Verified
public class YT_8_a_CheckPreorderTraversalOrNot {
    public static void main(String[] args) {
        System.out.println("Example 1:");
        int[] arr = {40, 30, 35, 80, 100};
        System.out.println(isPreorderBst(arr));
        System.out.println("Example 2:");
        int[] arr2 = {40, 30, 35, 20, 80, 100};
        System.out.println(isPreorderBst(arr2));
    }

    private static boolean isPreorderBst(int[] arr) {
        Stack<Integer> s = new Stack<>();
        int parent = Integer.MIN_VALUE;
        s.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            while (!s.isEmpty() && s.peek() < arr[i]) {
                parent = s.pop();
            }
            if (arr[i] < parent) {
                return false;
            }
            s.push(arr[i]);
        }

        return true;
    }
}
