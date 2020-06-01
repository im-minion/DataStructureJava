public class MergeSortedLinkedLits {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(1);
        l1.insertElementAtLast(4);
        l1.insertElementAtLast(7);
        l1.insertElementAtLast(9);

        LinkedList l2 = new LinkedList();
        l2.insertElementAtLast(2);
        l2.insertElementAtLast(3);
        l2.insertElementAtLast(6);
        l2.insertElementAtLast(8);
        l2.insertElementAtLast(10);

        l1.display();
        l2.display();
        
        // Non-Recursion Method
        System.out.println("\n\nResult Form Non-Recursion --->");
        mergeTwoLists(l1.head, l2.head);

        // Recursion Call
        LinkedList result = new LinkedList();
        Node resultHead = mergeTwoListsRecursion(l1.head, l2.head);
        System.out.println("\n\nResult Form Recursion --->\n");
        result.displayFromHead(resultHead);

    }

    private static Node mergeTwoListsRecursion(Node n1, Node n2) {

        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        if (n1.data <= n2.data) {
            n1.next = mergeTwoListsRecursion(n1.next, n2);
            return n1;
        } else {
            n2.next = mergeTwoListsRecursion(n1, n2.next);
            return n2;
        }

    }

    private static void mergeTwoLists(Node n1, Node n2) {
        LinkedList result = new LinkedList();
        while (n1 != null || n2 != null) {
            if (n1 == null) {
                result.insertElementAtLast(n2.data);
                n2 = n2.next;
                break;
            }
            if (n2 == null) {
                result.insertElementAtLast(n1.data);
                n1 = n1.next;
                break;
            }
            if (n1.data <= n2.data) {
                result.insertElementAtLast(n1.data);
                n1 = n1.next;
            } else {
                result.insertElementAtLast(n2.data);
                n2 = n2.next;
            }
        }
        result.display();
    }

}