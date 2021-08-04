import java.util.Stack;

public class Q_234_PalindromeLinkedList {
    //not working
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        if(head.next == null) return true;
        if(head.next.next == null) {
            if(head.val == head.next.val) {
                return true;
            }else {
                return false;
            }
        }
        ListNode actualHead = head;
        ListNode slow = head;
        ListNode fast = head;
        Stack<Integer> s = new Stack<>();
        while(fast.next!= null && fast.next.next!= null) {
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast.next == null ) {//odd
            if(!s.isEmpty()) {
                s.pop();
                slow = slow.next;
                while(!s.isEmpty() && slow != null) {
                    if(slow.val != s.peek()){
                        return false;
                    }
                    slow = slow.next;
                    s.pop();
                }
            }
            // actual center


        }else {//even
            if(!s.isEmpty()) {
                // s.pop();
                slow = slow.next;
                while(!s.isEmpty() && slow != null) {
                    if(slow.val != s.peek()){
                        return false;
                    }
                    slow = slow.next;
                    s.pop();
                }
            }
        }
        return true;

    }
}
