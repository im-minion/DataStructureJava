package linkedlist;

public class Q1_LinkedList {
    public Node head; // head of list

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


    public void cllPushEnd(int newData) {
        Node nodeToInsert = new Node(newData);
        if (head == null) {
            head = nodeToInsert;
            nodeToInsert.next = nodeToInsert;
        } else {
            Node n = head;
            while (n.next != head) {
                n = n.next;
            }
            n.next = nodeToInsert;
            nodeToInsert.next = head;
        }
    }


    public void cllPushFront(int newData) {
        Node nodeToInsert = new Node(newData);
        if (head == null) {
            head = nodeToInsert;
            nodeToInsert.next = nodeToInsert;
        } else {
            Node pointsToHead = head.next;
            while (pointsToHead.next != head) {
                pointsToHead = pointsToHead.next;
            }
            nodeToInsert.next = head;
            head = nodeToInsert;
            pointsToHead.next = head;
        }
    }

    public static void printCircularLinkedList(Node head) {
        if (head == null) {
            System.out.println("NULL LIST");
            return;
        }
        Node n = head;
        System.out.print(n.data + " -> ");
        n = n.next;
        if (n == head) {
            System.out.print("AgainHead(" + n.data + ")");
            return;
        }
        while (n != head) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.print("AgainHead(" + n.data + ")");
    }

    public static void printLinkedList(Node head) {
        Node n = head;
        while (n != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println("null");
    }
}

