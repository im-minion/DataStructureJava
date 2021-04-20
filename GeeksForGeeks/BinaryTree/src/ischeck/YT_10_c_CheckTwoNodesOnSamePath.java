package ischeck;

import introduction.BinaryTree;
import introduction.Node;

public class YT_10_c_CheckTwoNodesOnSamePath {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        boolean op = areOnSamePath(tree.root, 2, 5);
        System.out.println(op);
    }

    private static boolean areOnSamePath(Node root, int a, int b) {
        if (root == null) return false;
        MyClass myClass = new MyClass();
        lca(root, a, b, myClass);
        return myClass.isOnSamePath;
    }

    private static Node lca(Node root, int a, int b, MyClass myClass) {
        if (root == null) return root;

        if (root.key == a || root.key == b) {
            return root;
        }
        Node l = lca(root.left, a, b, myClass);
        Node r = lca(root.right, a, b, myClass);

        if (l != null && r != null) {
            myClass.isOnSamePath = false;
            return root;
        }

        if (l != null) return l;

        if (r != null) return r;

        return null;


    }

    private static class MyClass {
        boolean isOnSamePath = true;
    }
}
