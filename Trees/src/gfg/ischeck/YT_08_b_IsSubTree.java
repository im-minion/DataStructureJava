package gfg.ischeck;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

import java.util.LinkedList;
import java.util.Queue;

// GIVING TLE :(
public class YT_08_b_IsSubTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(44);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);


        BinaryTree tree2 = new BinaryTree();
        tree2.root = new Node(2);

        tree2.root.left = new Node(4);
        tree2.root.right = new Node(5);

        boolean op = isSubtree(tree.root, tree2.root);
        System.out.println(op);
    }

    private static boolean isSubtree(Node root, Node root1) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node t = queue.poll();
            if (t.key == root1.key) {
                if (isIdentical(t, root1)) {
                    return true;
                }
                if (t.left != null) queue.add(t.left);
                if (t.right != null) queue.add(t.right);
            }
        }
        return false;
    }

    private static boolean isIdentical(Node root1, Node root2) {
        if (root1 == null && root2 == null)
            return true;
        if (root1 == null || root2 == null)
            return false;

        if (root1.key != root2.key)
            return false;

        return isIdentical(root1.right, root2.right) && isIdentical(root1.left, root2.left);
    }
}
