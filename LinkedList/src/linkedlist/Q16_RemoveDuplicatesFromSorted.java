package linkedlist;

/*
Remove duplicates from a sorted linked list
Difficulty Level : Easy
Last Updated : 23 Feb, 2021
Write a function which takes a list sorted in non-decreasing order and deletes any duplicate nodes from the list.
The list should only be traversed once.
For example if the linked list is 11->11->11->21->43->43->60 then removeDuplicates() should convert the list to 11->21->43->60.
*/

public class Q16_RemoveDuplicatesFromSorted {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();
        llist.push(20);
        llist.push(20);
        llist.push(20);
        llist.push(20);
        llist.push(13);
        llist.push(13);
        llist.push(13);
        llist.push(12);
        llist.push(11);
        llist.push(11);
        llist.push(11);

        System.out.println("List before removal of duplicates");
        Q1_LinkedList.printLinkedList(llist.head);


        Node opHead = removeDuplicates(llist.head);
        System.out.println("List after removal of elements");
        Q1_LinkedList.printLinkedList(opHead);
    }

    private static Node removeDuplicates(Node head) {
        Node n = head;
        while (n != null && n.next != null) {
            if (n.data == n.next.data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
        return head;
    }
}
