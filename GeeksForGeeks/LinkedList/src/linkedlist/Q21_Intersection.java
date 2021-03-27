package linkedlist;

/*
Intersection of two Sorted Linked Lists
Difficulty Level : Medium

Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists. The new list should be made with its own memory — the original lists should not be changed.
Example:

Input:
First linked list: 1->2->3->4->6
Second linked list be 2->4->6->8,
Output: 2->4->6.
The elements 2, 4, 6 are common in
both the list so they appear in the
intersection list.

Input:
First linked list: 1->2->3->4->5
Second linked list be 2->3->4,
Output: 2->3->4
The elements 2, 3, 4 are common in
both the list so they appear in the
intersection list.
*/
public class Q21_Intersection {
    public static void main(String[] args) {
        Q1_LinkedList list = new Q1_LinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(6);

        Q1_LinkedList list2 = new Q1_LinkedList();
        // creating second linked list
        list2.head = new Node(25);
        list2.head.next = list.head.next;
        list2.head.next.next = new Node(24);
        list2.head.next.next.next = new Node(26);
        list2.head.next.next.next.next = new Node(28);

        // function call for intersection
        Node result = getIntersect(list.head, list2.head);

        // print required intersection
        System.out.println("Linked list containing common items of a & b");
        System.out.println(result.data);
    }

    private static Node getIntersect(Node head, Node head1) {
        Node a = head;
        Node b = head1;
        while (a != b) {
            a = a.next == null ? head1 : a.next;
            b = b.next == null ? head : b.next;
        }
        return a;
    }
}
