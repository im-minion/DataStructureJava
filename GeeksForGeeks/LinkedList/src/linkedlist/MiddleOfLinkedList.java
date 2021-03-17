package linkedlist;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        for (int i = 5; i > 0; --i) {
            llist.push(i);
            LinkedList.printLinkedList(llist.head);
            Node mid = printMiddle(llist.head);
            System.out.println("Middle" + mid.data);
        }
    }

    private static Node printMiddle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null && fastPointer.next.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        if(fastPointer != null && fastPointer.next == null && slowPointer.next != null) {
            return slowPointer.next;
        }

        return slowPointer;
    }
}
