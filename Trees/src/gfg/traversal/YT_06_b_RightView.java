package gfg.traversal;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

import java.util.LinkedList;
import java.util.Queue;

public class YT_06_b_RightView {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        printRightView(tree.root);
    }

    private static void printRightView(Node root) {
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        boolean isFirst = true;

        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            Node n = queue.poll();

            if (n == null) {
                if (queue.size() == 0) {
                    return;
                }
                queue.add(null);
                isFirst = true;
            } else {
                if (isFirst) {
                    System.out.println(n.key);
                    isFirst = false;

                    if (n.right != null) queue.add(n.right);
                    if (n.left != null) queue.add(n.left);
                }
            }
        }
    }
}
