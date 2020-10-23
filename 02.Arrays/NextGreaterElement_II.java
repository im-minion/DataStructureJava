import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement_II {
    public static int[] nextGreaterElement(int[] nums1) {

        int len = nums1.length;
        int[] ans = new int[nums1.length];

        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len * 2; i++) {
            while (!stack.isEmpty() && nums1[stack.peek()] < nums1[i % len]) {
                ans[stack.pop()] = nums1[i % len];
            }
            if (i < len) {
                stack.push(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = { 1, 2, 1 };

        int result[] = nextGreaterElement(nums1);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
