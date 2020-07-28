import java.util.Stack;

public class QueueUsingTwoStacks {

    Stack<Integer> newItems = new Stack<>();
    Stack<Integer> oldItems = new Stack<>();

    private void enqueue(Integer item) {
        if (item == null) {
            return;
        }
        oldItems.push(item);
    }

    private Integer dequeue() {
        shiftItems();
        return newItems.pop();
    }

    public Integer peek() {
        shiftItems();
        return newItems.peek();
    }

    private void shiftItems() {
        // old items to new items
        if(newItems.isEmpty()) {
            if(oldItems.isEmpty()) {
                throw new IllegalStateException("Stack Underflow Exception: Stack is Empty!");
            }
        }
        while(!oldItems.isEmpty()) {
            newItems.push(oldItems.pop());
        }
    }

    public static void main(String[] args) {
        QueueUsingTwoStacks queue = new QueueUsingTwoStacks();
        System.out.println("Building queue.");
        queue.enqueue(15);
        queue.enqueue(20);
        queue.enqueue(10);
        queue.enqueue(45);
        System.out.println("Removed : " + queue.dequeue());
        queue.enqueue(50);
        System.out.println("Removed : " + queue.dequeue());
        System.out.println("peeked : " + queue.peek());
        System.out.println("Removed : " + queue.dequeue());
        System.out.println("peeked : " + queue.peek());
    }
}