public class StackUsingArray {
    private int capacity;
    private int size;
    private int top;
    private int[] array;

    public StackUsingArray(int initialCapacity) {
        this.capacity = initialCapacity;
        this.array = new int[initialCapacity];
        this.size = 0;
        this.top = -1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == capacity;
    }

    private int pop() {
        if (isEmpty()) {
            throw new IllegalStateException(
                    "Stack Underflow Exception: Can't perform pop operation when the stack is Empty!");
        }
        this.size--;
        return this.array[this.top--];
    }

    private int peek() {
        if (isEmpty()) {
            throw new IllegalStateException(
                    "Stack Underflow Exception: Can't perform peek operation when the stack is Empty!");
        }
        return this.array[this.top];
    }

    private void push(int i) {
        if (isFull()) {
            throw new IllegalStateException(
                    "Stack Overflow Exception: Can't perform push operation when the stack is Full!");
        }
        this.size++;
        this.top += 1;
        this.array[this.top] = i;
    }

    public static void main(String[] args) {
        System.out.println("Creating stack.");
        int initialCapacity = 10;
        StackUsingArray stack = new StackUsingArray(initialCapacity);
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