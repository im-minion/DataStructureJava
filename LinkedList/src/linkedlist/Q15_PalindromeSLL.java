package linkedlist;

import java.util.Stack;

/*
Function to check if a singly linked list is palindrome
Difficulty Level : Medium

Given a singly linked list of characters, write a function that returns true if the given list is a palindrome, else false.
*/
public class Q15_PalindromeSLL {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(3);
        Node six = new Node(2);
        Node seven = new Node(1);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        boolean condition = isPalindrome(one);
        System.out.println("isPalidrome :" + condition);
    }

    private static boolean isPalindrome(Node head) {
        Stack<Integer> stack = new Stack<>();
        Node n = head;

        while (n != null) {
            stack.push(n.data);
            n = n.next;
        }

        n = head;
        while (n != null) {
            if (!stack.isEmpty() && stack.pop() != n.data) {
                return false;
            }
            n = n.next;
        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }
}
