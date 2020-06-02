public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(1);
        l1.insertElementAtLast(2);
        l1.insertElementAtLast(3);
        l1.insertElementAtLast(4);
        l1.insertElementAtLast(5);
        l1.insertElementAtLast(6);
        l1.display();

        Node resultHead = reverseLinkedList(l1.head);
        l1.displayFromHead(resultHead);
    }

    private static Node reverseLinkedList(Node head) {
        Node newHead = null;
        while(head != null) {
            Node next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}