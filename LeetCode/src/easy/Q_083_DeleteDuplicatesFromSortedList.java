public class Q_083_DeleteDuplicatesFromSortedList {
    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode t = head;
        while (t != null && t.next != null) {
            int currVal = t.val;
            ListNode nxt = t.next;
            while (nxt != null && nxt.val == currVal) {
                nxt = nxt.next;
            }
            t.next = nxt;
            t = t.next;
        }

        return head;
    }
}
