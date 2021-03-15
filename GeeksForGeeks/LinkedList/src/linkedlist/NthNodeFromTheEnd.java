package linkedlist;

public class NthNodeFromTheEnd {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.push(20);
        llist.push(4);
        llist.push(15);
        llist.push(35);
        LinkedList.printLinkedList(llist.head);
        int r = nthFromLast(1, llist.head);
        System.out.println(r);
    }

    private static int nthFromLast(int n, Node head) {
        Node mainPointer = head;
        Node secondPointer = head;

        int count = 0;

        while (secondPointer != null) {
            count++;
            if (count > n) {
                mainPointer = mainPointer.next;
            }
            secondPointer = secondPointer.next;
        }
        if (mainPointer == null) {
            return -1;
        }

        return mainPointer.data;
    }
}
