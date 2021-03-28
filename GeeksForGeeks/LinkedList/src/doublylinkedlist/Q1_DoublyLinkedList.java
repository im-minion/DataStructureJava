package doublylinkedlist;

public class Q1_DoublyLinkedList {

    Node head; // head of list


    public static void main(String[] args) {
        Q1_DoublyLinkedList doublyLinkedList = new Q1_DoublyLinkedList();

        doublyLinkedList.append(6);

        doublyLinkedList.push(10);

        doublyLinkedList.push(7);

        doublyLinkedList.push(8);

        doublyLinkedList.push(3);

        doublyLinkedList.push(1);


        System.out.println("Created DLL is: ");
        doublyLinkedList.printlist(doublyLinkedList.head);

        doublyLinkedList.deleteNode(doublyLinkedList.head);

        System.out.println("\nAfter Deleting: ");
        doublyLinkedList.printlist(doublyLinkedList.head);
    }

    void deleteNode(Node del) {
        // Base case
        if (head == null || del == null) {
            return;
        }

        // If node to be deleted is head node
        if (head == del) {
            head = del.next;
        }

        // Change next only if node to be deleted is NOT the last node
        if (del.next != null) {
            del.next.prev = del.prev;
        }

        // Change prev only if node to be deleted is NOT the first node
        if (del.prev != null) {
            del.prev.next = del.next;
        }

        // Finally, free the memory occupied by del
        return;
    }


    // Adding a node at the front of the list
    public void push(int newData) {
        /* 1. allocate node
         * 2. put in the data */
        Node newNode = new Node(newData);

        /* 3. Make next of new node as head and previous as NULL */
        newNode.next = head;
        newNode.prev = null;

        /* 4. change prev of head node to new node */
        if (head != null) {
            head.prev = newNode;
        }

        /* 5. move the head to point to the new node */
        head = newNode;
    }

    public void InsertAfter(Node prevNode, int newData) {

        /*1. check if the given prev_node is NULL */
        if (prevNode == null) {
            System.out.println("The given previous node cannot be NULL ");
            return;
        }

        /* 2. allocate node
         * 3. put in the data */
        Node newNode = new Node(newData);

        /* 4. Make next of new node as next of prev_node */
        newNode.next = prevNode.next;

        /* 5. Make the next of prev_node as newNode */
        prevNode.next = newNode;

        /* 6. Make prev_node as previous of newNode */
        newNode.prev = prevNode;

        /* 7. Change previous of newNode's next node */
        if (newNode.next != null)
            newNode.next.prev = newNode;
    }

    // Add a node at the end of the list
    void append(int new_data) {
        /* 1. allocate node
         * 2. put in the data */
        Node new_node = new Node(new_data);

        Node last = head; /* used in step 5*/

        /* 3. This new node is going to be the last node, so
         * make next of it as NULL*/
        new_node.next = null;

        /* 4. If the Linked List is empty, then make the new
         * node as head */
        if (head == null) {
            new_node.prev = null;
            head = new_node;
            return;
        }

        /* 5. Else traverse till the last node */
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;

        /* 7. Make last node as previous of new node */
        new_node.prev = last;
    }

    // This function prints contents of
    // linked list starting from the given node
    public void printlist(Node node) {
        Node last = null;
        System.out.println("Traversal in forward Direction");
        while (node != null) {
            System.out.print(node.data + " ");
            last = node;
            node = node.next;
        }
        System.out.println();
        System.out.println("Traversal in reverse direction");
        while (last != null) {
            System.out.print(last.data + " ");
            last = last.prev;
        }
    }


}
