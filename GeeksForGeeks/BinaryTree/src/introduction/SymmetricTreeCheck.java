package introduction;

public class SymmetricTreeCheck {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(4);
        tree.root.right.right = new Node(3);
        boolean output = isSymmetric(tree.root);
        if (output)
            System.out.println("Symmetric");
        else
            System.out.println("Not symmetric");
    }

    private static boolean isSymmetric(Node root) {
        if (root == null) return true; //no nodes
        if (root.left == null && root.right == null) {
            return true; //only one node
        }
        if (root.left != null && root.right != null) {
            return isSymm(root.left, root.right);
        }
        return false;
    }

    private static boolean isSymm(Node left, Node right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.key == right.key) {
            return isSymm(left.left, right.right) && isSymm(left.right, right.left);
        } else {
            return false;
        }
    }
}
