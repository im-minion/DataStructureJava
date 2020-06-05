public class IntersectionList {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(1);
        l1.insertElementAtLast(2);
        l1.insertElementAtLast(3);
        l1.insertElementAtLast(4);
        l1.insertElementAtLast(5);
        l1.insertElementAtLast(6);
        l1.display();

        LinkedList l2 = new LinkedList();
        l2.insertElementAtLast(66);
        l2.insertElementAtLast(33);
        l2.insertElementAtLast(44);
        l2.insertElementAtLast(3);
        l2.insertElementAtLast(4);
        l2.insertElementAtLast(5);
        l2.display();

        Node resultHead = getIntersection(l1.head, l2.head);
        // ResultHead will be the intersection node
        //With above data its not possible to create a list with intersections
    }

    private static Node getIntersection(Node head, Node head2) {
        if (head == null || head2 == null)
            return null;
        Node a = head;
        Node b = head2;

        while (a != b) {
            a = a == null ? head2 : a.next;
            b = b == null ? head : b.next;
        }

        return a;
    }
}