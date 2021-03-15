package linkedlist;

public class Deletion {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.push(7);
        llist.push(1);
        llist.push(3);
        llist.push(2);

        System.out.println("Before");
        LinkedList.printLinkedList(llist.head);

        Node h = deleteNode(3, llist.head);
        System.out.println("After");
        LinkedList.printLinkedList(h);
    }

    private static Node deleteNode(int i, Node head) {
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
