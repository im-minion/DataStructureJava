package linkedlist;

public class Q5_LengthOfLinkedList {
    public static void main(String[] args) {
        /* Start with the empty list */
        Q1_LinkedList llist = new Q1_LinkedList();
        llist.push(1);
        llist.push(3);
        llist.push(1);
        llist.push(2);
        llist.push(1);

        System.out.println("Iterative :: Count of nodes is " + getCount(llist.head));

        System.out.println("Recursive:: Count of nodes is " + getCount2(llist.head));


    }

    private static int getCount(Node head) {
        int count = 0;
        Node n = head;
        while (n != null) {
            count++;
            n = n.next;
        }
        return count;
    }


    private static int getCount2(Node head) {
        if (head == null) return 0;
        return 1 + getCount2(head.next);
    }
}
