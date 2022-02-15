package circularlinkedlist;

import linkedlist.Node;
import linkedlist.Q1_LinkedList;

/*
Sorted insert for circular linked list
Difficulty Level : Easy

Difficulty Level: Rookie
Write a C function to insert a new value in a sorted Circular Linked List (CLL). For example, if the input CLL is following.
*/
public class Q4_SortedInsert {
    public static void main(String[] args) {
        Q1_LinkedList list = new Q1_LinkedList();
        list.head = new Node(0);
        // Creating the linkedlist
        int arr[] = new int[]{12, 56, 2, 11, 1, 90};

        /* start with empty linked list */
        Node nodeToInsert = null;

        /* Create linked list from the array arr[].
         Created linked list will be 1->2->11->12->56->90*/

        for (int i = 0; i < 6; i++) {
            nodeToInsert = new Node(arr[i]);
            sortedInsert(list, nodeToInsert);
        }

        Q1_LinkedList.printCircularLinkedList(list.head);
    }

    private static void sortedInsert(Q1_LinkedList list, Node nodeToInsert) {
        if (list.head == null) {
            list.head = nodeToInsert;
        } else {
            Node prev = list.head;
            Node n = list.head.next;
            if (n == null) { // only one node
                if (list.head.data < nodeToInsert.data) {
                    list.head.next = nodeToInsert;
                } else {
                    list.head.next = nodeToInsert;
                    list.head = nodeToInsert;
                }
                return;
            }
            while (n != null && n != list.head && n.data <= nodeToInsert.data) {
                prev = n;
                n = n.next;
            }
            prev.next = nodeToInsert;
            nodeToInsert.next = n;
        }
//        Node current = list.head;
//
//        // Case 1 of the above algo
//        if (current == null) {
//            new_node.next = new_node;
//            list.head = new_node;
//
//        }
//
//        // Case 2 of the above algo
//        else if (current.data >= new_node.data) {
//
//            /* If value is smaller than head's value then
//             we need to change next of last node */
//            while (current.next != list.head)
//                current = current.next;
//
//            current.next = new_node;
//            new_node.next = list.head;
//            list.head = new_node;
//        }
//
//        // Case 3 of the above algo
//        else {
//
//            /* Locate the node before the point of insertion */
//            while (current.next != list.head &&
//                    current.next.data < new_node.data)
//                current = current.next;
//
//            new_node.next = current.next;
//            current.next = new_node;
//        }
    }
}
