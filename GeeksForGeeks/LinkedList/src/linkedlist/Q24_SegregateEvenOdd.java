package linkedlist;

/*
Segregate even and odd nodes in a Linked List
Difficulty Level : Medium

Given a Linked List of integers, write a function to modify the linked list such that
all even numbers appear before all the odd numbers in the modified linked list.
Also, keep the order of even and odd numbers same.

Examples:

Input: 17->15->8->12->10->5->4->1->7->6->NULL
Output: 8->12->10->4->6->17->15->5->1->7->NULL

Input: 8->12->10->5->4->1->6->NULL
Output: 8->12->10->4->6->5->1->NULL

// If all numbers are even then do not change the list
Input: 8->12->10->NULL
Output: 8->12->10->NULL

// If all numbers are odd then do not change the list
Input: 1->3->5->7->NULL
Output: 1->3->5->7->NULL*/

public class Q24_SegregateEvenOdd {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();
        llist.push(11);
        llist.push(10);
        llist.push(9);
        llist.push(6);
        llist.push(4);
        llist.push(1);
        llist.push(0);
        System.out.println("Origional Linked List");
        Q1_LinkedList.printLinkedList(llist.head);

        Node opHead = segregateEvenOdd(llist.head);

        System.out.println("Modified Linked List");
        Q1_LinkedList.printLinkedList(opHead);
    }

    private static Node segregateEvenOdd(Node head) {
        Node currOddList = null;
        Node currEvenList = null;
        Node oddListHead = null;
        Node evenListHead = null;

        Node node = head;

        while (node != null) {
            if (node.data % 2 == 0) {
                if (currEvenList == null) {
                    evenListHead = node;
                    currEvenList = evenListHead;
                } else {
                    currEvenList.next = node;
                    currEvenList = currEvenList.next;
                }
            } else {
                if (currOddList == null) {
                    oddListHead = node;
                    currOddList = oddListHead;
                } else {
                    currOddList.next = node;
                    currOddList = currOddList.next;
                }
            }
            node = node.next;
        }
        if(currEvenList != null) {
            currEvenList.next = oddListHead;
        }else {
            evenListHead = oddListHead;
        }
        return evenListHead;
    }
}
