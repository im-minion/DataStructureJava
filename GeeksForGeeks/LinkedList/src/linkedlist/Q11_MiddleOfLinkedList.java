package linkedlist;

public class Q11_MiddleOfLinkedList {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();
        for (int i = 5; i > 0; --i) {
            llist.push(i);
            Q1_LinkedList.printLinkedList(llist.head);
            Node mid = printMiddle(llist.head);
            System.out.println("Middle : " + mid.data);
            System.out.println();
        }
    }

    private static Node printMiddle(Node head) {
        Node slowPointer = head;
        Node fastPointer = head;

        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        return slowPointer;
    }
}
