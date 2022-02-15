package misc;
/**
 * Next Greater Element I
 * 
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. 
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * 
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 
 * If it does not exist, output -1 for this number.
 * Example 1:
 * 
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 *  Output: [-1,3,-1]
 * 
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * 
 * Example 2:
 * 
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * 
 * Output: [3,-1]
 * 
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * 
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 * 
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] num1 = { 4, 1, 2 };
        int[] num2 = { 1, 3, 4, 2 };
        for (int num : nextGreaterElement(num1, num2)) {
            System.out.print(num + " ");
        }

        System.out.println("\n");

        int[] num3 = { 2, 4 };
        int[] num4 = { 1, 2, 3, 4 };

        for (int num : nextGreaterElement(num3, num4)) {
            System.out.print(num + " ");
        }
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numToNextGreaterMap = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer currNo : nums2) {
            while (!stack.isEmpty() && stack.peek() < currNo) { // need while loop think about a case [8,7,6,5,10]
                numToNextGreaterMap.put(stack.pop(), currNo);
            }
            stack.push(currNo);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = numToNextGreaterMap.getOrDefault(nums1[i], -1);
        }

        return nums1;
    }
}