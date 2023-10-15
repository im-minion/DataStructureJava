package medium;

import util.ListNode;

public class Q_019_RemoveNthFromLastInLL {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return head;

        int size = 0;

        ListNode t = head;
        while (t != null) {
            size++;
            t = t.next;
        }

        int traverseTill = size - n;// + 1;

        if (traverseTill == 0) return head.next;

        ListNode prev = null;
        ListNode curr = head;

        while (traverseTill > 0) {
            prev = curr;
            curr = curr.next;
            traverseTill--;
        }
        ListNode temp = curr.next;
        prev.next = temp;

        return head;
    }
}
