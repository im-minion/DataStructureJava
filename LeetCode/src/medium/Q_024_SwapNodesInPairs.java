package medium;

public class Q_024_SwapNodesInPairs {
    public static void main(String[] args) {
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode prev = head.next.next;

        if (prev == null) {  //for size == 2
            ListNode newHead = head.next;
            newHead.next = head;
            head.next = null;
            return newHead;
        }

        ListNode curr = head.next.next.next;

        ListNode newHead = head.next;
        newHead.next = head;
        head.next = prev;
        ListNode prevPrev = newHead.next;


        while (curr != null) {
            prevPrev.next = curr;
            ListNode t = curr.next;
            curr.next = prev;
            prev.next = t;

            prevPrev = prev;
            prev = prev.next;
            if (prev == null)
                return newHead;
            curr = prev.next;
        }

        return newHead;

    }
}
