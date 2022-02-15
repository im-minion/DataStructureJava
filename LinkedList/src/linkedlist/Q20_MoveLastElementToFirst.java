package linkedlist;

public class Q20_MoveLastElementToFirst {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();
        /* Constructed Linked List is 1->2->3->4->5->null */
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before moving last to front ");
        Q1_LinkedList.printLinkedList(llist.head);

        Node newNode = moveToFront(llist.head);

        System.out.println("Linked List after moving last to front ");
        Q1_LinkedList.printLinkedList(newNode);
    }

    private static Node moveToFront(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            //only two node  case;
            Node last = head.next;
            last.next = head;
            head.next = null;
            return last;
        }

        Node secLast = head;
        while (secLast.next.next != null) {
            secLast = secLast.next;
        }
        Node last = secLast.next;
        Node temp = head.next;
        head.next = null;
        secLast.next = head;
        last.next = temp;

        return last;
    }

}
