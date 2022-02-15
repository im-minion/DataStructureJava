package linkedlist;

public class Q4_Deletion {
    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);

        System.out.println("Before");
        Q1_LinkedList.printLinkedList(llist.head);

        Node h = deleteNodeAtSpecificIndex(0, llist.head);
        System.out.println("After deleteNodeAtSpecificIndex");
        Q1_LinkedList.printLinkedList(h);

        h = deleteNodeWithSpecificValue(3, llist.head);
        System.out.println("After deleteNodeWithSpecificValue");
        Q1_LinkedList.printLinkedList(h);
    }

    private static Node deleteNodeAtSpecificIndex(int index, Node head) {
        Node node = head;
        if (index == 0) {
            head = head.next;
            return head;
        }
        int count = 0;
        while (count != (index - 1)) {
            if (node != null) {
                node = node.next;
                count++;
            }
        }
        if (node == null || node.next == null) {
            System.out.println("Couldn't Delete");
            return head;
        }
        node.next = node.next.next;
        return head;
    }

    private static Node deleteNodeWithSpecificValue(int i, Node head) {
        Node n = head;

        if (n == null) {
            return head;
        }

        // head delete
        if (n.data == i) {
            head = n.next;
            n.next = null;
            return head;
        }


        // otherwise any delete
        while (n.next != null && n.next.data != i) {
            n = n.next;
        }
        if (n.next != null) {
            n.next = n.next.next;
        } else {
            System.out.println("couldn't delete");
        }
        return head;
    }
}
