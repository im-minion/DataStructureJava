package linkedlist;

/*
Reverse a linked list
Difficulty Level : Medium
Last Updated : 03 Mar, 2021

Given pointer to the head node of a linked list, the task is to reverse the linked list. We need to reverse the list by changing the links between nodes.

Examples:

Input: Head of following linked list
1->2->3->4->NULL
Output: Linked list should be changed to,
4->3->2->1->NULL

Input: Head of following linked list
1->2->3->4->5->NULL
Output: Linked list should be changed to,
5->4->3->2->1->NULL

Input: NULL
Output: NULL
*/
public class Q25_ReverseLL {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();
        llist.push(11);
        llist.push(10);
        llist.push(8);
        llist.push(6);
        llist.push(4);
        llist.push(2);
        llist.push(0);
        System.out.println("Origional Linked List");
        Q1_LinkedList.printLinkedList(llist.head);

        Node opHead = reverse(llist.head);

        System.out.println("Modified Linked List");
        Q1_LinkedList.printLinkedList(opHead);
    }

    private static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}
