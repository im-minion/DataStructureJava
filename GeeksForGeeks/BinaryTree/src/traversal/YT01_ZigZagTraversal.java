package traversal;

import introduction.BinaryTree;
import introduction.Node;

import java.util.Stack;

public class YT01_ZigZagTraversal {
    public static void main(String[] args) {
        /*Node Insertion*/
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        printZigZagTraversal(tree.root);
    }

    private static void printZigZagTraversal(Node root) {
        if (root == null) return;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        s1.add(root);
        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                Node n = s1.pop();
                System.out.print(n.key + " ");
                if (n.left != null) s2.add(n.left);
                if (n.right != null) s2.add(n.right);
            }
            while (!s2.empty()) {
                Node n = s2.pop();
                System.out.print(n.key + " ");
                if (n.right != null) s1.add(n.right);
                if (n.left != null) s1.add(n.left);
            }
        }

    }
}
