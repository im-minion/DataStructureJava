package linkedlist;

public class Insertion {
    public static void main(String[] args) {
        LinkedList l = new LinkedList();
        l.head = new Node(1);
        l.head.next = new Node(2);
        l.head.next.next = new Node(3);

        System.out.println("Original :");
        LinkedList.printLinkedList(l.head);

        System.out.println("insertAtTheFront :");
        l.head = insertAtTheFront(new Node(5), l.head);
        LinkedList.printLinkedList(l.head);

        System.out.println("insertAfter :");
        insertAfter(l.head.next, new Node(99));
        LinkedList.printLinkedList(l.head);

        System.out.println("insertAtTheEnd :");
        insertAtTheEnd(new Node(9), l.head);
        LinkedList.printLinkedList(l.head);

    }

    private static void insertAfter(Node preGivenNode, Node nodeToInsert) {
        Node temp = preGivenNode.next;
        preGivenNode.next = nodeToInsert;
        nodeToInsert.next = temp;
    }

    private static Node insertAtTheEnd(Node nodeToInsert, Node head) {
        Node n = head;
        while (n.next != null)
            n = n.next;
        n.next = nodeToInsert;
        return head;
    }

    private static Node insertAtTheFront(Node nodeToInsert, Node head) {
        nodeToInsert.next = head;
        head = nodeToInsert;
        return head;
    }
}
