package linkedlist;

public class Q1_LinkedList {
    Node head; // head of list

    /* Linked list Node. This inner class is made static so that main() can access it */

    public static void main(String[] args) {
        Q1_LinkedList list = new Q1_LinkedList();

        list.head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        list.head.next = second;
        second.next = third;

        printLinkedList(list.head);

    }

    /* Inserts a new Node at front of the list. */
    public void push(int newData) {
        Node newNode = new Node(newData);
        newNode.next = head;
        head = newNode;
    }

    static void printLinkedList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }
}

