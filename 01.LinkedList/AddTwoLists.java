public class AddTwoLists {

    public static void main(final String args[]) {
        LinkedList l1 = new LinkedList();
        l1.insertElementAtLast(4);
        l1.insertElementAtLast(5);
        l1.insertElementAtLast(6);
        l1.display();

        LinkedList l2 = new LinkedList();
        l2.insertElementAtLast(4);
        l2.insertElementAtLast(5);
        l2.insertElementAtLast(9);
        l2.display();

        LinkedList resultLinkedList = new LinkedList();

        System.out.println("Adding Above two lists");
        Node l1Current = l1.head;
        Node l2Current = l2.head;
        int carry = 0;

        while (l1Current != null || l2Current != null) {
            int currentSum = carry + l1Current.data + l2Current.data;
            carry = currentSum / 10;
            resultLinkedList.insertElementAtLast(currentSum % 10);
            System.out.print(currentSum % 10);
            l1Current = l1Current != null ? l1Current.next : null;
            l2Current = l2Current != null ? l2Current.next : null;
        }
        if (carry != 0) {
            resultLinkedList.insertElementAtLast(carry);;
        }

        resultLinkedList.display();
    }
}