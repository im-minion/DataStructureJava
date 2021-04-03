package introduction;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

    public Node root;

    BinaryTree(int data) {
        this.root = new Node(data);
    }

    BinaryTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(5);
        Node op = insertAtFirstAvailablePosition(binaryTree.root, 6);
        op = insertAtFirstAvailablePosition(op, 7);
        op = insertAtFirstAvailablePosition(op, 8);
        op = insertAtFirstAvailablePosition(op, 9);
        op = insertAtFirstAvailablePosition(op, 10);
        op = insertAtFirstAvailablePosition(op, 3);
        System.out.println("InOrder :: ");
        printInorderTraversal(op);

        System.out.println("\nPreOrder :: ");
        printPreOrderTraversal(op);

        System.out.println("\nPostOrder :: ");
        printPostOrderTraversal(op);
    }

    private static void printPostOrderTraversal(Node root) {
        if (root.left != null) {
            printPostOrderTraversal(root.left);
        }
        if (root.right != null) {
            printPostOrderTraversal(root.right);
        }
        System.out.print(root.key + " ");
    }

    private static void printPreOrderTraversal(Node root) {
        System.out.print(root.key + " ");
        if (root.left != null) {
            printPreOrderTraversal(root.left);
        }
        if (root.right != null) {
            printPreOrderTraversal(root.right);
        }
    }

    private static void printInorderTraversal(Node root) {
        if (root.left != null) {
            printInorderTraversal(root.left);
        }
        System.out.print(root.key + " ");
        if (root.right != null) {
            printInorderTraversal(root.right);
        }
    }

    public static Node insertAtFirstAvailablePosition(Node root, int data) {
        Node nodeToInsert = new Node(data);
        if (root == null) {
            return nodeToInsert;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            Node temp = q.peek();
            q.remove();
            if (temp.left == null) {
                temp.left = nodeToInsert;
                break;
            } else {
                q.add(temp.left);
            }

            if (temp.right == null) {
                temp.right = nodeToInsert;
                break;
            } else {
                q.add(temp.right);
            }
        }
        return root;
    }
}
