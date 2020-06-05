public class CycleDetection {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(1);
        l1.insertElementAtLast(4);
        l1.insertElementAtLast(7);
        l1.insertElementAtLast(9);

        boolean hasCycle = hasCycle(l1.head);
        if (hasCycle) {
            System.out.println("HAS CYCLE");
        } else{
            System.out.println("NO CYCLE");
        }
    }

    private static boolean hasCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}