package linkedlist;

public class Q12_Count {
    private static int countRec = 0;

    public static void main(String[] args) {
        Q1_LinkedList llist = new Q1_LinkedList();
        llist.push(3);
        llist.push(4);
        llist.push(9);
        llist.push(3);
        Q1_LinkedList.printLinkedList(llist.head);
        int r = count(llist.head, 3);
        System.out.println(r);

        r = recursiveCount(llist.head, 3);
        System.out.println(r);
    }

    private static int recursiveCount(Node node, int key) {
        if (node == null) {
            return 0;
        }
        if (node.data == key) {
            countRec++;
        }
        node = node.next;
        recursiveCount(node, key);
        return countRec;

    }

    private static int count(Node head, int key) {
        int count = 0;
        Node n = head;
        while (n != null) {
            if (n.data == key) {
                count++;
            }
            n = n.next;
        }
        return count;
    }
}
