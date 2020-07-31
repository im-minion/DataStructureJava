public class QueueUsingArray {

    private int size;
    private int capacity;
    private int front;
    private int rear;

    private Integer[] container = null;

    public QueueUsingArray(int initialCapacity) {
        this.size = 0;
        this.front = -1;
        this.rear = -1;
        this.capacity = initialCapacity;
        this.container = new Integer[this.capacity];
    }

    private int peekNew() {
        if (size == 0 || this.container.length == 0)
            throw new IllegalStateException("Queue is Empty!");

        return this.container[this.size -1];
    }

    private int peekOld() {
        if (size == 0 || this.container.length == 0)
            throw new IllegalStateException("Queue is Empty!");
        return this.container[0];
    }

    private int dequeue() {
        if (size == 0 || this.container.length == 0)
            throw new IllegalStateException("Queue is Empty!");

        int itemToRemove = this.container[0];
        int index = 0;
        for (int i = 1; i < this.container.length; i++) {
            this.container[index++] = this.container[i];
        }
        this.size--;
        return itemToRemove;
    }

    private void enqueue(int i) {
        if (size == (capacity)) {
            throw new IllegalStateException("Queue size exceeded!");
        }
        this.container[this.size++] = i;
    }

    public static void main(String[] args) {
        System.out.println("Creating LinkedList based queue.");
        QueueUsingArray queue = new QueueUsingArray(4);
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
        System.out.println(String.format("dequeued %s", queue.dequeue()));
    }

}