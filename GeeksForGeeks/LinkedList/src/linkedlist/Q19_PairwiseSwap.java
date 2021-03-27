package linkedlist;

/*
Pairwise swap elements of a given linked list
Difficulty Level : Easy
Last Updated : 13 Nov, 2020
Given a singly linked list, write a function to swap elements pairwise.

Input : 1->2->3->4->5->6->NULL
Output : 2->1->4->3->6->5->NULL

Input : 1->2->3->4->5->NULL
Output : 2->1->4->3->5->NULL

Input : 1->NULL
Output : 1->NULL

For example, if the linked list is 1->2->3->4->5 then
the function should change it to 2->1->4->3->5, and if the linked list is then the function should change it to .
*/

public class Q19_PairwiseSwap {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();

        /* Created Linked List 1->2->3->4->5 */
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.println("Linked List before calling pairWiseSwap() ");
        Q1_LinkedList.printLinkedList(llist.head);

        Node opHead = pairWiseSwap(llist.head);

        System.out.println("Linked List after calling pairWiseSwap() ");
        Q1_LinkedList.printLinkedList(opHead);
    }

    private static Node pairWiseSwap(Node head) {
        Node temp = head;

        /* Traverse only till there are atleast 2 nodes left */
        while (temp != null && temp.next != null) {

            /* Swap the data */
            int k = temp.data;
            temp.data = temp.next.data;
            temp.next.data = k;
            temp = temp.next.next;
        }
        return head;
    }
}
