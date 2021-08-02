import java.util.Stack;

public class Q_232_ImplementQueueUsingStack {
    public static void main(String[] args) {

    }

    class MyQueue {
        int size = 0;
        Stack<Integer> s;
        int front = -1;
        boolean isFirst = true;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            this.s = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            this.size++;
            s.push(x);
            if (isFirst) {
                this.front = x;
                isFirst = false;
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            this.size = this.size - 1;
            Stack<Integer> temp = this.s;
            this.s = new Stack<>();
            isFirst = true;
            int x = 0;
            int op = -1;
            for (int i : temp) {
                if (x == 0) {
                    op = i;
                } else {
                    this.s.push(i);

                    if (isFirst) {
                        this.front = i;
                        isFirst = false;
                    }
                }
                x++;
            }
            return op;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return this.front;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return this.size == 0;
        }
    }

}
