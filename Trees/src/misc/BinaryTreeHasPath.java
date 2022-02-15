package misc;

import java.util.List;

/*
 
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

 */

public class BinaryTreeHasPath {
    public static boolean hasPathSum(BTNode root, int sum) {
        if (root == null) {
            return false;
        } else if (root.left == null && root.right == null && sum - root.data == 0) {
            return true;
        } else {
            return hasPathSum(root.left, sum - root.data) || hasPathSum(root.right, sum - root.data);
        }
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

        boolean outputNode = hasPathSum(root1, 7);

        System.out.println("\n\nOUTPUT:");
        System.out.println(outputNode);

        System.out.println(hasPathSum(root1, 9));
    }
}