class Node {
	int data;
	Node next;

	public Node(final int data) {
		this.data = data;
	}
}

public class LinkedList {
	private Node head;
	private int size = 0;

	public static void main(final String args[]) {
		LinkedList linkedList = new LinkedList();
		linkedList.display();
		linkedList.insertElement(22);
		linkedList.insertElement(23);
		linkedList.insertElement(25);
		linkedList.display();
	}

	private void display() {
		if (isEmpty() || size == 0) {
			System.out.println("Linked List is empty");
		} else {
			Node currentNode = head;
			System.out.print(currentNode.data);
			currentNode = currentNode.next;
			while (currentNode != null) {
				System.out.print(" -> " + currentNode.data);
				currentNode = currentNode.next;
			}
			System.out.print(" ->  null ");
		}
	}

	private boolean isEmpty() {
		return this.head == null;
	}

	private void insertElement(int data) {
		Node nodeToInsert = new Node(data);
		if (isEmpty()) {
			this.head = nodeToInsert;
			this.size++;
		} else {
			Node currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = nodeToInsert;
			this.size++;
		}
	}
}