package mics;

public class MiddleOfLinkedList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(1);
        l1.insertElementAtLast(2);
        l1.insertElementAtLast(3);
        l1.insertElementAtLast(4);
        l1.insertElementAtLast(5);
        l1.display();

        int middleElement = getMiddleOfLL(l1.head);
        System.out.println(middleElement);
    }

    private static int getMiddleOfLL(Node head) {
        Node slow = head;
        Node fast = head;

        while(slow.next != null && fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
} 