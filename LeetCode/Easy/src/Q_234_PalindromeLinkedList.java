import java.util.Stack;

public class Q_234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next == null) return false;

        ListNode actualHead = head;
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> s = new Stack<>();
        while(fast.next!= null && fast.next.next!= null) {
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next == null ) {
            s.pop(); // actual center


        }else {

        }
//        while(){
//
//        }
        return true;

    }
}
