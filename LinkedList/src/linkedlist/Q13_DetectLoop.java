package linkedlist;

public class Q13_DetectLoop {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;
        System.out.println("is loop in LL " + detectLoop(llist.head));

    }

    private static boolean detectLoop(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;
        if (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        while (fastPointer != null && fastPointer.next != null) {
            if (slowPointer == fastPointer) {
                return true;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return false;
    }
}
