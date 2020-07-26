import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    Queue<Integer> queue;

    public StackUsingQueue() {
        this.queue = new LinkedList<>();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int pop() {
        return this.queue.poll();
    }

    public int peek() {
        return this.queue.peek();
    }

    public void push(int x) {
        this.queue.add(x);
        for (int i = 0; i < this.queue.size() - 1; i++) {
            this.queue.add(queue.poll());
            // remove element from start and insert at last
        }
    }

    public static void main(String[] args) {
        System.out.println("Creating stack.");
        StackUsingQueue stack = new StackUsingQueue();
        System.out.println("Pushing elements to the top of stack.");
        stack.push(10);
        System.out.println(String.format("pushed %s", stack.peek()));
        stack.push(20);
        System.out.println(String.format("pushed %s", stack.peek()));
        stack.push(50);
        System.out.println(String.format("pushed %s", stack.peek()));
        stack.push(40);
        System.out.println(String.format("pushed %s", stack.peek()));
        stack.push(30);
        System.out.println(String.format("pushed %s", stack.peek()));

        System.out.println("Popping elements off the stack.");
        System.out.println(String.format("popping %s", stack.pop()));
        System.out.println(String.format("Now at top %s", stack.peek()));
        System.out.println(String.format("popping %s", stack.pop()));
        System.out.println(String.format("Now at top %s", stack.peek()));
        System.out.println(String.format("popping %s", stack.pop()));
        System.out.println(String.format("Now at top %s", stack.peek()));
        System.out.println(String.format("popping %s", stack.pop()));
        System.out.println(String.format("Now at top %s", stack.peek()));
    }
}