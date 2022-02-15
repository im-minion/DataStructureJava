package gfg.ischeck;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

// VERIFIED
public class YT_09_a_IsSumTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        boolean output = isSumTree(tree.root);
        System.out.println(output);
    }

    private static boolean isSumTree(Node root) {
        if (root == null) return false;
        MyClass myClass = new MyClass();
        evaluateIsSumTree(root, myClass);
        return myClass.isSum;
    }

    private static int evaluateIsSumTree(Node root, MyClass myClass) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return root.key;
        int l = evaluateIsSumTree(root.left, myClass);
        int r = evaluateIsSumTree(root.right, myClass);
        if (root.key == l + r) {
            myClass.isSum = true;
        }
        return l + r + root.key;
    }

    private static class MyClass {
        boolean isSum = false;
    }
}
