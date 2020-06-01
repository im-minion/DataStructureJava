class Node {
	public int data;
	public Node next;

	public Node(final int data) {
		this.data = data;
	}
}

public class LinkedList {
	public Node head;
	public int size = 0;

	public static void main(final String args[]) {
		LinkedList linkedList = new LinkedList();
		linkedList.display();
		linkedList.insertElementAtLast(22);
		linkedList.insertElementAtLast(23);
		linkedList.insertElementAtLast(25);
		linkedList.display();
		linkedList.insertElementAtFirst(1);
		linkedList.display();
		linkedList.insertElementAtSpecificIndex(3, 555);
		linkedList.display();
		linkedList.deleteByKey(22);
		linkedList.display();
		linkedList.deleteAtIndex(0);
		linkedList.display();
	}

	public void display() {
		if (isEmpty() || size == 0) {
			System.out.println("Linked List is empty");
		} else {
			System.out.println("\nSize of Linked List : " + size);
			Node currentNode = head;
			System.out.print(currentNode.data);
			currentNode = currentNode.next;
			while (currentNode != null) {
				System.out.print(" -> " + currentNode.data);
				currentNode = currentNode.next;
			}
			System.out.print(" -> null\n");
		}
	}

	public void displayFromHead(Node headNode) {
		if(headNode != null) {
			Node currentNode = headNode;
			System.out.print(currentNode.data);
			currentNode = currentNode.next;
			while (currentNode != null) {
				System.out.print(" -> " + currentNode.data);
				currentNode = currentNode.next;
			}
			System.out.print(" -> null\n");
		} else {
			System.out.println("Linked List is empty");
		}
	}

	private boolean isEmpty() {
		return this.head == null;
	}

	public void insertElementAtLast(int data) {
		Node nodeToInsert = new Node(data);
		if (isEmpty()) {
			this.head = nodeToInsert;
		} else {
			Node currentNode = head;
			while (currentNode.next != null) {
				currentNode = currentNode.next;
			}
			currentNode.next = nodeToInsert;
		}
		this.size++;
	}

	private void insertElementAtFirst(int data) {
		Node nodeToInsert = new Node(data);
		if (isEmpty()) {
			this.head = nodeToInsert;
		} else {
			Node currentFirst = this.head;
			this.head = nodeToInsert;
			this.head.next = currentFirst;
		}
		this.size++;
	}

	private void insertElementAtSpecificIndex(int index, int data) {
		if (index >= 0) {
			if (isEmpty() || index == 0) {
				this.insertElementAtFirst(data);
			} else {
				Node nodeToInsert = new Node(data);
				Node currentNode = this.head;
				for (int i = 0; i < (index); i++) {
					if (currentNode != null) {
						currentNode = currentNode.next;
					} else {
						throw new IllegalStateException("Can't traverse upto given index : " + index
								+ ", because size of current Linked List : " + this.size);
					}
				}
				if (currentNode != null) {
					Node tempNode = currentNode.next;
					currentNode.next = nodeToInsert;
					nodeToInsert.next = tempNode;
					this.size++;
				} else {
					throw new IllegalStateException("Can't traverse upto given index : " + index
							+ ", because size of current Linked List : " + this.size);
				}

			}
		} else {
			throw new IllegalStateException("Index can't be less than 0");
		}
	}

	private void deleteByKey(int data) {
		if (isEmpty() || this.size == 0) {
			System.out.println("Linked List is Empty");
		} else {
			int index = 0;
			Node currentNode = this.head;
			while (currentNode != null && currentNode.data != data) {
				currentNode = currentNode.next;
				index++;
			}
			if (currentNode != null) {
				System.out.println("Given data is present at index : " + index);
				// delete currentNode
				this.head = this.head.next;
				this.size--;
			} else {
				System.out.println("DELETE OPERATION: Given data is NOT present in Linked List");
			}
		}
	}

	private void deleteAtIndex(int index) {
		if (index >= 0) {
			if (isEmpty()) {
				throw new IllegalStateException("Linked List is Empty Can't perform delete operation");
			} else {
				// Node nodeToInsert = new Node(data);
				if(index == 0) {
					this.head = this.head != null ? this.head.next : null;
					this.size--;
					return;
				}
				Node currentNode = this.head;
				for (int i = 0; i < (index - 1); i++) {
					if (currentNode != null) {
						currentNode = currentNode.next;
					} else {
						throw new IllegalStateException("Can't traverse upto given index : " + index
								+ ", because size of current Linked List : " + this.size);
					}
				}
				if (currentNode != null) {
					if (currentNode.next != null) {
						currentNode.next = currentNode.next.next;
						this.size--;
					} else
						currentNode.next = null;
				} else {
					throw new IllegalStateException("Can't traverse upto given index : " + index
							+ ", because size of current Linked List : " + this.size);
				}

			}
		} else {
			throw new IllegalStateException("Index can't be less than 0");
		}
	}

}