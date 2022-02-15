package misc;/*

 Binary Tree Right Side View

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public static List<Integer> rightSideView(BTNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        result.add(root.data);
        getRightSideView(root, result, 0);
        return result;
    }

    public static void getRightSideView(BTNode node, List<Integer> result, int level) {
        if (node == null)
            return;
        if (result.size() == level) {
            result.add(node.data);
        } else {
            result.set(level, node.data);
        }
        getRightSideView(node.left, result, level + 1);
        getRightSideView(node.right, result, level + 1);
    }

    public static void main(String[] args) {
        System.out.println("Construct a binary tree");
        BTNode root1 = new BTNode(1);
        root1.left = new BTNode(2);
        root1.right = new BTNode(3);
        root1.left.left = new BTNode(4);
        root1.left.right = new BTNode(5);
        root1.right.left = new BTNode(6);
        root1.right.right = new BTNode(7);
        System.out.println("binary tree constructed.");
        System.out.println("INPUT:");
        List<BTNode> input = BinaryTreeInOrderTraversal.inOrderTraversal(root1);
        input.stream().forEach(node -> System.out.print(node.data + " "));

        List<Integer> outputNode = rightSideView(root1);

        System.out.println("\n\nOUTPUT:");
        outputNode.stream().forEach(op -> System.out.print(op + " "));
    }
}