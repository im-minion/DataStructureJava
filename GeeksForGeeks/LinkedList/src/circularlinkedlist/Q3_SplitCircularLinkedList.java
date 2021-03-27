package circularlinkedlist;

import linkedlist.Node;
import linkedlist.Q1_LinkedList;

public class Q3_SplitCircularLinkedList {
    public static void main(String[] args) {
        Q1_LinkedList list = new Q1_LinkedList();

        //Created linked list will be 12->56->2->11
        list.head = new Node(12);
        list.head.next = new Node(56);
        list.head.next.next = new Node(2);
        list.head.next.next.next = new Node(11);
        list.head.next.next.next.next = list.head;

        System.out.println("Original Circular Linked list ");
        Q1_LinkedList.printCircularLinkedList(list.head);

        // Split the list
        Node[] opNode = splitList(list.head);
        System.out.println("");
        System.out.println("First Circular List ");
        Q1_LinkedList.printCircularLinkedList(opNode[0]);

        System.out.println("");
        System.out.println("Second Circular List ");
        Q1_LinkedList.printCircularLinkedList(opNode[1]);
    }

    private static Node[] splitList(Node head) {
        Node[] op = new Node[2];

        if (head == null || head.next == head) {
            op[0] = head;
            return op;
        }

        if (head.next.next == head) {
            Node first = head;
            Node second = head.next;
            first.next = null;
            second.next = null;
            op[0] = first;
            op[1] = second;
            return op;
        }

        Node slowPointer = head.next;
        Node fastPointer = head.next.next;

        while (fastPointer != head && fastPointer.next != head && fastPointer.next.next != head) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }

        if (fastPointer.next.next == head) {
            fastPointer = fastPointer.next;
        }
        Node secondHead = slowPointer.next;
        fastPointer.next = slowPointer.next;
        slowPointer.next = head;

        op[0] = head;
        op[1] = secondHead;
        return op;
    }
}
