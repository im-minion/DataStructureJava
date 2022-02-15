import java.util.Stack;

public class Q_234_PalindromeLinkedList {
    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(0);
        l.next.next = new ListNode(0);
        System.out.println(isPalindrome(l));
    }

    //not working
    public static boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        if (head.next == null) return true;
        if (head.next.next == null) {
            return head.val == head.next.val;
        }
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> s = new Stack<>();
        s.push(slow.val);
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            s.push(slow.val);
            fast = fast.next.next;
        }

        if (fast.next == null) {//odd-actual center
            if (!s.isEmpty()) {
                s.pop();
                slow = slow.next;
                while (!s.isEmpty() && slow != null) {
                    System.out.println("Here im in odd");
                    if (slow.val != s.peek()) {
                        return false;
                    }
                    slow = slow.next;
                    s.pop();
                }
            }
        } else {//even-has 2 centers
            slow = slow.next;
            while (!s.isEmpty() && slow != null) {
                if (slow.val != s.peek()) {
                    System.out.println("Here im in even");
                    return false;
                }
                slow = slow.next;
                s.pop();
            }
        }
        return true;
    }
}
