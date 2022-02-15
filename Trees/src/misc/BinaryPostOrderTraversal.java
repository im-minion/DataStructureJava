package misc;

import java.util.ArrayList;
import java.util.List;

public class BinaryPostOrderTraversal {
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

        List<Integer> recursiveOutput = postorderTraversal(root);

        System.out.println("Printing recursive output.");
        for (Integer i : recursiveOutput) {
            System.out.print(i + " ");
        }
    }

    public static List<Integer> postorderTraversal(BTNode root) {
        List<Integer> output = new ArrayList<>();
        if (root == null)
            return output;
        getPostOrderTraversal(root, output);
        return output;
    }

    public static void getPostOrderTraversal(BTNode node, List<Integer> output) {
        if (node == null)
            return;
        getPostOrderTraversal(node.left, output);
        getPostOrderTraversal(node.right, output);
        output.add(node.data);
    }
}