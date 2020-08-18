import java.util.List;

public class SumOfLeftLeaves {
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
        int outputNode = sumOfLeftLeaves(root1);
        System.out.println("\n\nOUTPUT: " + outputNode);
    }

    private static int sumOfLeftLeaves(BTNode root) {
        if (root == null)
            return 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            return root.left.data + sumOfLeftLeaves(root.right);
        } else {
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
    }
}