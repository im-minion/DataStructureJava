package height;

import introduction.BinaryTree;
import introduction.Node;

public class YT_03_DiameterOfBinaryTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        int op = diameterOfBinaryTree(tree.root);
        System.out.println(op);
    }

    private static int diameterOfBinaryTree(Node root) {
        Obj obj = new Obj();
        height(root, obj);
        return obj.d;
    }

    private static int height(Node root, Obj obj) {
        if (root == null) return 0;

        int lh = height(root.left, obj);
        int rh = height(root.right, obj);

        obj.d = Math.max(obj.d, lh + rh + 1);

        return 1 + Math.max(lh, rh);
    }
}

class Obj {
    int d = 0;
}