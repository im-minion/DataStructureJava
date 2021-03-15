package linkedlist;

public class Searching {
    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        /*Use push() to construct below list
        14->21->11->30->10  */
        llist.push(10);
        llist.push(30);
        llist.push(11);
        llist.push(21);
        llist.push(14);

        if (search(llist.head, 14))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean search(Node head, int key) {
        Node n = head;
        while (n != null) {
            if (n.data == key) {
                return true;
            }
            n = n.next;
        }
        return false;
    }
}
