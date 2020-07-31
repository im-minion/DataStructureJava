public class CircularQueueUsingArray {

    int front = -1, rear = -1;

    int container[];

    int size;
    int capacity;

    private CircularQueueUsingArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.container = new int[this.capacity];
        this.size = 0;
    }

    private int dequeue() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }
        int itemToRemove;
        if (this.front == this.rear) {
            itemToRemove = this.container[this.front];
            this.front--;
            this.rear--;
        } else if (front == (capacity - 1)) {
            itemToRemove = container[front];
            front = 0;
        } else {
            itemToRemove = this.container[front];
            front++;
        }
        this.size--;
        return itemToRemove;
    }

    private void enqueue(int i) {
        if (this.isFull()) {
            throw new IllegalStateException("Queue size exceeded!");
        }
        if (this.isEmpty()) {
            this.rear++;
            this.front++;
            this.container[this.rear] = i;
        } else if (this.rear == (this.capacity - 1) && this.front != 0) {
            this.rear = 0;
            this.container[this.rear] = i;
        } else {
            this.container[++this.rear] = i;
        }
        this.size++;
    }

    private int peekNew() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }
        return this.container[this.rear];
    }

    private int peekOld() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Queue is Empty!");
        }
        return this.container[this.front];
    }

    private boolean isEmpty() {
        return this.size == 0;
    }

    private boolean isFull() {
        return this.size == this.capacity;
    }

    private void printFrontToRear() {
        System.out.println("********Displaying the Queue from Front to Rear**********");
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }

        if (this.front <= this.rear) {

            for (int i = this.front; i <= this.rear; i++) {

                System.out.print(this.container[i] + "  ");
            }
        } else {
            for (int i = this.front; i < this.capacity; i++) {

                System.out.println(this.container[i] + "  ");
            }

            for (int j = 0; j <= this.rear; j++) {

                System.out.println(this.container[j] + "  ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Creating an instance of circular queue!");
        CircularQueueUsingArray queue = new CircularQueueUsingArray(4);
        System.out.println("\n\nEnqueue elements.");
        queue.enqueue(10);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.enqueue(20);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.printFrontToRear();
        System.out.println("Dequeue elements.");
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        queue.printFrontToRear();

        System.out.println("\n\nEnqueue elements.");
        queue.enqueue(30);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.enqueue(40);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.printFrontToRear();
        System.out.println("Dequeue elements.");
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        queue.printFrontToRear();

        System.out.println("\n\nEnqueue elements.");
        queue.enqueue(10);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.enqueue(20);
        System.out.println(String.format("enqueued %s", queue.peekNew()));
        queue.printFrontToRear();
        System.out.println("Dequeue elements.");
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        System.out.println(String.format("Next element to be dequeued %s", queue.peekOld()));
        System.out.println(String.format("dequeued %s", queue.dequeue()));
        queue.printFrontToRear();
    }

}