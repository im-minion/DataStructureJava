package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleArea {
    public static void main(String[] args) {
//        (ArrayList<Integer>) Arrays.asList(2, 1, 5, 6, 2, 3)
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(1);
        a.add(5);
        a.add(6);
        a.add(2);
        a.add(3);
        System.out.println(largestRectangleArea(a));
    }

    public static int largestRectangleArea(ArrayList<Integer> A) {
        if (null == A || A.isEmpty()) {
            return 0;
        }
        if (A.size() == 1) {
            return A.get(0);
        } //(2, 1, 5, 6, 2, 3)
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < A.size()) {
            System.out.println("first start => " + stack);
            if (stack.isEmpty() || A.get(stack.peek()) <= A.get(i)) {
                stack.push(i);
                i++;
            } else {
                int top = stack.pop();
                int height = A.get(top);
                int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
                System.out.println("height : " + height + ", width :"+ width);
                max = Math.max(max, height * width);
            }
            System.out.println("first end => " + stack);
        }
        while (!stack.isEmpty()) {
            System.out.println("second start => " + stack);
            int top = stack.pop();
            int height = A.get(top);
            int width = stack.isEmpty() ? i : (i - stack.peek() - 1);
            System.out.println("height : " + height + ", width :"+ width);
            max = Math.max(max, height * width);
            System.out.println("second end => " + stack);
        }
        return max;
    }
}
