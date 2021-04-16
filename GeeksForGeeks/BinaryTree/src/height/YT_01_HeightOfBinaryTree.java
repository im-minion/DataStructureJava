package height;

import introduction.BinaryTree;
import introduction.Node;

public class YT_01_HeightOfBinaryTree {
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


        int op = getHeightOfBinaryTree(tree.root);
        System.out.println(op);
    }

    public static int getHeightOfBinaryTree(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(getHeightOfBinaryTree(root.left), getHeightOfBinaryTree(root.right));
    }
}
