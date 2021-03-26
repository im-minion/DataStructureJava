package linkedlist;
/*
Find length of loop in linked list
Difficulty Level:Easy
Last Updated:20Jun,2020
Write a function detectAndCountLoop()that checks whether a given Linked List contains loop and
if loop is present then returns count of nodes in loop.
For example,the loop is present in below-linked list and length of the loop is 4.
If the loop is not present,then the function should return 0.
*/

public class Q14_LengthOfLoop {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(10);

        /*Create loop for testing */
        llist.head.next.next.next.next = llist.head;
        System.out.println("Iterative :: Count of nodes is " + getLengthOfLoop(llist.head));
    }

    private static int getLengthOfLoop(Node head) {
        int count = 0;
        Node slowPointer = head;
        Node fastPointer = head;
        if (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        while (fastPointer != null && fastPointer.next != null) {

            if (slowPointer == fastPointer) {
                slowPointer = slowPointer.next;

                while (slowPointer != fastPointer) {
                    count++;
                    slowPointer = slowPointer.next;
                }
                return count;
            }
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return count;
    }
}
