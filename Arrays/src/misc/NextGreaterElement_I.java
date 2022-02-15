package misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement_I {

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {
            while (!stack.empty() && stack.peek() < num) {
                hashMap.put(stack.pop(), num);
            }
            stack.push(num);
        }

        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hashMap.getOrDefault(nums1[i], -1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 4, 1, 2 };
        int nums2[] = { 1, 3, 4, 2 };

        int result[] = nextGreaterElement(nums1, nums2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}