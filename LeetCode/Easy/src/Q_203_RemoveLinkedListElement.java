public class Q_203_RemoveLinkedListElement {
    public static void main(String[] args) {

    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;

        // if head is the val
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) return head;

        ListNode prev = head;
        ListNode curr = head.next;


        while (curr != null) {
            ListNode next = curr.next;
            if (curr.val == val) {
                prev.next = next;
                curr.next = null;
                curr = next;
            } else {
                prev = curr;
                curr = next;
            }
        }

        return head;
    }
}
