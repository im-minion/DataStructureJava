package misc;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * 
 * Example 1:
 * 
 * Input ["misc.MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation misc.MinStack minStack = new misc.MinStack(); minStack.push(-2);
 * minStack.push(0); minStack.push(-3); minStack.getMin(); // return -3
 * minStack.pop(); minStack.top(); // return 0 minStack.getMin(); // return -2
 * 
 * 
 * Constraints:
 * 
 * Methods pop, top and getMin operations will always be called on non-empty
 * stacks.
 */
public class MinStackImpl {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top()); // return 0
        System.out.println(minStack.getMin()); // return -2
    }

}

class MinStack {

    int min = Integer.MAX_VALUE;
    Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        // if the current value(x) to push is less than already existing min then push
        // the old min value first and then the actual value
        // else only push the current value(x)
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        // perform pop()
        int popedValue = stack.pop();
        // if poped value is the min then
        // the new value which on the top will be the new_mini
        // so pop again and update min to that value
        if (popedValue == min) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
