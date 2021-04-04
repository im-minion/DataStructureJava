package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.Stack;

public class InorderTraversalWithoutRecursionUsingStack {
    public static void main(String[] args) {

        /*Node Insertion*/
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        printInorderWithoutRecursion(tree.root);
    }

    private static void printInorderWithoutRecursion(Node root) {
        Node current = root;
        Stack<Node> stack = new Stack<>();
        while (current != null || stack.size() > 0) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            System.out.print(current.key + " ");
            current = current.right;
        }

    }
}
