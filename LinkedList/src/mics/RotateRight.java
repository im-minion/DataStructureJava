package mics;

public class RotateRight {
    public static void main(String[] args) {
        int rotateByPlaces = 2;
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(1);
        l1.insertElementAtLast(2);
        l1.insertElementAtLast(3);
        l1.insertElementAtLast(4);
        l1.insertElementAtLast(5);
        l1.insertElementAtLast(6);
        l1.display();

        Node resultHead = rotateRight(l1, rotateByPlaces);
        l1.displayFromHead(resultHead);
    }

    private static Node rotateRight(LinkedList l1, int rotateByPlaces) {
        rotateByPlaces = (rotateByPlaces % l1.size);
        Node dummy = new Node(0);
        dummy.next = l1.head;
        Node currentNode = dummy.next;
        for (int i = 0; i < rotateByPlaces; i++) {
            Node currHead = currentNode;
            Node newHead = currentNode.next;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currHead.next = null;
            currentNode.next = currHead;
            currentNode = newHead;
        }
        return currentNode;
    }
}