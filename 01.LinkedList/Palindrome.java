public class Palindrome {

    public static void main(String[] args) {
        boolean isPalindrome = false;
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(1);
        l1.insertElementAtLast(2);
        l1.insertElementAtLast(3);
        l1.insertElementAtLast(3);
        l1.insertElementAtLast(2);
        l1.insertElementAtLast(1);
        l1.display();

        Node reverseListHead = ReverseLinkedList.reverseLinkedList(l1.head);
        l1.displayFromHead(reverseListHead);
        Node currL1 = l1.head;
        while (reverseListHead != null && currL1 != null) {
            if (reverseListHead.data == currL1.data) {
                reverseListHead = reverseListHead.next;
                currL1 = currL1.next;
                isPalindrome = true;
            } else {
                isPalindrome = false;
                System.out.println("NOT PALINDROME");
                break;
            }
        }
        if (isPalindrome) {
            System.out.println("PALINDROME");
        }
    }
}