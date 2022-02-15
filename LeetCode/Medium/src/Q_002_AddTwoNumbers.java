//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}

public class Q_002_AddTwoNumbers {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        int carry = 0;
        ListNode op = new ListNode(0);
        ListNode ret = op;
        while (l1 != null && l2 != null) {
            int currSum = carry + l1.val + l2.val;
            int oneDigitSum = currSum % 10;
            op.next = new ListNode(oneDigitSum);
            carry = currSum / 10;
            op = op.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            int currSum = carry + l1.val;
            int oneDigitSum = currSum % 10;
            op.next = new ListNode(oneDigitSum);
            carry = currSum / 10;
            op = op.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            int currSum = carry + l2.val;
            int oneDigitSum = currSum % 10;
            op.next = new ListNode(oneDigitSum);
            carry = currSum / 10;
            op = op.next;
            l2 = l2.next;
        }

        if (carry != 0) op.next = new ListNode(carry);

        return ret.next;
    }
}
