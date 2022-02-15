package linkedlist;

/*
Remove duplicates from a sorted linked list
Difficulty Level : Easy
Last Updated : 23 Feb, 2021
Write a function which takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list.
The list should only be traversed once.
For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list to 11->21->43->60.
*/

import java.util.HashSet;

public class Q17_RemoveDuplicatesFromUnSorted {

    public static void main(String[] args) {
        Q1_LinkedList list = new Q1_LinkedList();
        list.head = new Node(10);
        list.head.next = new Node(12);
        list.head.next.next = new Node(11);
        list.head.next.next.next = new Node(6);
        list.head.next.next.next.next = new Node(12);
        list.head.next.next.next.next.next = new Node(8);
        list.head.next.next.next.next.next.next = new Node(10);

        System.out.println("List before removal of duplicates");
        Q1_LinkedList.printLinkedList(list.head);

        Node opHead = removeDuplicates(list.head);
        System.out.println("List after removal of elements");
        Q1_LinkedList.printLinkedList(opHead);
    }

    private static Node removeDuplicates(Node head) {
        Node n = head;
        Node prev = null;
        HashSet<Integer> hashSet = new HashSet<>();

        while (n != null) {
            if (hashSet.contains(n.data)) {
                prev.next = n.next;
            } else {
                hashSet.add(n.data);
                prev = n;
            }
            n = n.next;
        }

        return head;
    }
}