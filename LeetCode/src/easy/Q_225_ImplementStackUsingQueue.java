import java.util.LinkedList;
import java.util.Queue;

/*
Implement a last-in-first-out (LIFO) stack using only two queues.
The implemented stack should support all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

void push(int x) Pushes element x to the top of the stack.
int pop() Removes the element on the top of the stack and returns it.
int top() Returns the element on the top of the stack.
boolean empty() Returns true if the stack is empty, false otherwise.
Notes:

You must use only standard operations of a queue,
which means that only push to back, peek/pop from front, size and is empty operations are valid.
Depending on your language, the queue may not be supported natively.
You may simulate a queue using a list or deque (double-ended queue) as long as you use only a queue's standard operations.

Example 1:

Input
["MyStack", "push", "push", "top", "pop", "empty"]
[[], [1], [2], [], [], []]
Output
[null, null, null, 2, 2, false]

Explanation
MyStack myStack = new MyStack();
myStack.push(1);
myStack.push(2);
myStack.top(); // return 2
myStack.pop(); // return 2
myStack.empty(); // return False

*/
public class Q_225_ImplementStackUsingQueue {
    public static void main(String[] args) {

    }

    class MyStack {
        int top_ = -1;
        int size = 0;
        Queue<Integer> q;

        /**
         * Initialize your data structure here.
         */
        public MyStack() {
            this.q = new LinkedList<>();
            size = 0;
            top_ = -1;
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            size++;
            this.q.offer(x);
            this.top_ = x;
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            if (this.size == 1) {
                this.size--;
                return this.q.poll();
            }
            this.size = 0;
            Queue<Integer> temp = this.q;
            this.q = new LinkedList<>();
            for (int i = 0; i < temp.size(); i++) {
                int ele = temp.poll();
                this.size++;
                this.q.offer(ele);
                this.top_ = ele;
            }
            return temp.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return this.top_;
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return size == 0;
        }
    }

}
