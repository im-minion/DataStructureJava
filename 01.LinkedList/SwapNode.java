public class SwapNode {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(1);
        l1.insertElementAtLast(2);
        l1.insertElementAtLast(3);
        l1.insertElementAtLast(4);
        l1.insertElementAtLast(5);
        l1.insertElementAtLast(6);
        l1.display();

        Node resultHeadNode = swapNode(l1);

        l1.displayFromHead(resultHeadNode);
    }

    private static Node swapNode(LinkedList l1) {
        Node dummy = new Node(0);
        dummy.next = l1.head;

        Node currentNode = dummy;
        while( currentNode.next != null && currentNode.next.next != null) {
            Node first = currentNode.next;
            Node second = currentNode.next.next;
            first.next = second.next;
            second.next = first;
            currentNode.next = second;
            currentNode = first;
        }
        // l1.displayFromHead(currentNode);
        return dummy.next;
    }
}