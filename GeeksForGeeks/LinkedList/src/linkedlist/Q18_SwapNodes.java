package linkedlist;

/*
Swap nodes in a linked list without swapping data
Difficulty Level : Medium

Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links.
Swapping data of nodes may be expensive in many situations when data contains many fields.

It may be assumed that all keys in the linked list are distinct.
*/
public class Q18_SwapNodes {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();

        /* The constructed linked list is:
            1->2->3->4->5->6->7 */
        llist.push(7);
        llist.push(6);
        llist.push(5);
        llist.push(4);
        llist.push(3);
        llist.push(2);
        llist.push(1);

        System.out.print("\n Linked list before calling swapNodes() ");
        Q1_LinkedList.printLinkedList(llist.head);

        Node opHead = swapNodes(llist.head, 4, 3);

        System.out.print("\n Linked list after calling swapNodes() ");
        Q1_LinkedList.printLinkedList(opHead);
    }

    private static Node swapNodes(Node head, int x, int y) {
        if (x == y) {
            return head;
        }
        Node currX = head;
        Node prevX = null;

        while (currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node currY = head;
        Node prevY = null;

        while (currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }
        // swap
        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return head;

        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else // make y the new head
            head = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            head = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;


        return head;
    }
}
