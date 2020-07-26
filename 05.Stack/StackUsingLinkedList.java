import java.util.LinkedList;
import java.util.List;

public class StackUsingLinkedList {
    private List<Integer> linkedList;

    public StackUsingLinkedList() {
        linkedList = new LinkedList<>();
    }

    private boolean isEmpty() {
        return linkedList.isEmpty();
    }

    private int pop() {
        if (this.isEmpty()) {
            throw new IllegalStateException(
                    "Stack Underflow Exception: Can't perform pop operation when the stack is Empty!");
        }
        return linkedList.remove(linkedList.size() - 1);
    }

    private int peek() {
        if (this.isEmpty()) {
            throw new IllegalStateException(
                    "Stack Underflow Exception: Can't perform peek operation when the stack is Empty!");
        }
        return linkedList.get(linkedList.size() - 1);
    }

    private void push(int i) {
        linkedList.add(i);
    }

    public static void main(String[] args) {

        System.out.println("Creating stack.");
        StackUsingLinkedList stack = new StackUsingLinkedList();

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