import java.util.List;

public class IsUniValuedBinaryTree {
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
        boolean outputNode = isUniValuedBinaryTree(root1);
        System.out.println("\n\nOUTPUT: " + outputNode);

        BTNode root2 = new BTNode(1);
        root2.left = new BTNode(1);
        root2.right = new BTNode(1);
        root2.left.left = new BTNode(1);
        root2.left.right = new BTNode(1);
        root2.right.left = new BTNode(1);
        root2.right.right = new BTNode(1);
        System.out.println("binary tree constructed.");
        System.out.println("INPUT:");
        BinaryTreeInOrderTraversal.inOrderTraversal(root2).stream().forEach(node -> System.out.print(node.data + " "));
        outputNode = isUniValuedBinaryTree(root2);
        System.out.println("\n\nOUTPUT: " + outputNode);

    }

    private static boolean isUniValuedBinaryTree(BTNode node) {
        if (node == null)
            return true;

        return (node.left == null || node.left.data == node.data && isUniValuedBinaryTree(node.left))
                && (node.right == null || node.right.data == node.data && isUniValuedBinaryTree(node.right));
    }
}