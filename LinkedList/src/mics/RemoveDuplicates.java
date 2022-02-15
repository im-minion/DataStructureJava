package mics;

public class RemoveDuplicates {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(1);
        l1.insertElementAtLast(2);
        l1.insertElementAtLast(2);
        l1.insertElementAtLast(3);
        l1.insertElementAtLast(3);
        l1.insertElementAtLast(3);
        l1.display();
        Node resultHead = removeDuplicate(l1.head);
        l1.displayFromHead(resultHead);
    }

    private static Node removeDuplicate(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = removeDuplicate(head.next);
        return head.data == head.next.data ? head.next : head;
    }
}