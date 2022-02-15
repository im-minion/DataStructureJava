package circularlinkedlist;

import linkedlist.Q1_LinkedList;

public class Q1_CircularLinkedList {
    public static void main(String[] args) {
        /* Initialize lists as empty */
        Q1_LinkedList cll = new Q1_LinkedList();


        /* Created linked list will be 11.2.56.12 */
        cll.cllPushEnd(12);
        cll.cllPushEnd(56);
        cll.cllPushEnd(2);
        cll.cllPushEnd(11);


        System.out.println("Contents of Circular " + "Linked List:");
        Q1_LinkedList.printCircularLinkedList(cll.head);

        cll.cllPushFront(0);

        Q1_LinkedList.printCircularLinkedList(cll.head);
    }
}
