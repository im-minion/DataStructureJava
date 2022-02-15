package gfg.introduction;

public class FoldableTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.right.left = new Node(4);
        tree.root.left.right = new Node(5);

        if (isFoldable(tree.root))
            System.out.println("tree is foldable");
        else
            System.out.println("Tree is not foldable");
    }

    private static boolean isFoldable(Node root) {
        if (root == null) {
            return true;
        }
        if (root.right == null && root.left == null) {
            return true;
        }
        if (root.right == null || root.left == null) {
            return false;
        }

        return isFoldableRecursive(root.left, root.right);
    }

    private static boolean isFoldableRecursive(Node n1, Node n2) {
        if (n1 == null && n2 == null) {
            return true;
        }

        if (n1 == null || n2 == null) {
            return false;
        }

        return isFoldableRecursive(n1.left, n2.right) && isFoldableRecursive(n1.right, n2.left);
    }
}
