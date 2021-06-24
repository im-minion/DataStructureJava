public class Q_141_LinkedListCycle {
    public static void main(String[] args) {

    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode s = head;
        ListNode f = head;
        while (f.next != null && f.next.next != null) {
            s = s.next;
            f = f.next.next;
            if (s == f) return true;
        }

        return false;
    }
}
