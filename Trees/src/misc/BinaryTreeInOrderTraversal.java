package misc;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInOrderTraversal {
    public static void main(String[] args) {
        System.out.println("Creating a tree.");
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        System.out.println("Tree constructed.");

        List<BTNode> recursiveOutput = inOrderTraversal(root);

        System.out.println("Printing recursive output.");
        for (BTNode BTNode : recursiveOutput) {
            System.out.print(BTNode.data + " ");
        }
    }

    public static List<BTNode> inOrderTraversal(BTNode root) {
        List<BTNode> output = new ArrayList<>();
        if (root == null)
            return output;
        getInOrderTraversal(root, output);
        return output;
    }

    private static void getInOrderTraversal(BTNode node, List<BTNode> output) {
        if (node == null)
            return;
        getInOrderTraversal(node.left, output);
        output.add(node);
        getInOrderTraversal(node.right, output);
    }

}