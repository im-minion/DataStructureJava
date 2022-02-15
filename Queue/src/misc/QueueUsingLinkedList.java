package misc;

import java.util.LinkedList;

public class QueueUsingLinkedList {

    LinkedList<Integer> container = null;

    public QueueUsingLinkedList() {
        this.container = new LinkedList<>();
    }

    private int peekOld() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }
        return this.container.getFirst();
    }

    private int dequeue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }
        return this.container.removeFirst();
    }

    private void enqueue(int i) {
        this.container.add(i);
    }

    private int peekNew() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }
        return this.container.getLast();
    }

    private boolean isEmpty() {
        return this.container.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println("Creating LinkedList based queue.");
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        System.out.println("Enqueue elements.");
        queue.enqueue(10);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.enqueue(20);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.enqueue(30);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.enqueue(40);
        System.out.println(String.format("enqueued %s", queue.peekNew()));

        System.out.println("Dequeue elements.");
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
    }
}