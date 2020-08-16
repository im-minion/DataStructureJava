import java.util.List;

/*

Convert 
     4
   /   \
  2     7
 / \   / \
1   3 6   9

1234679
    
to


     4
   /   \
  7     2
 / \   / \
9   6 3   1

9764321

*/

public class InvertBinaryTree {

    public static BTNode invertTree(BTNode root) {
        if (root == null) {
            return root;
        }
        BTNode leftNode = invertTree(root.left);
        BTNode rightNode = invertTree(root.right);
        root.right = leftNode;
        root.left = rightNode;

        return root;
    }

    public static void main(String[] args) {
        System.out.println("Construct a binary tree");
        BTNode root1 = new BTNode(20);
        root1.left = new BTNode(10);
        root1.right = new BTNode(30);
        root1.left.left = new BTNode(5);
        root1.left.right = new BTNode(15);
        root1.right.left = new BTNode(25);
        root1.right.right = new BTNode(40);
        System.out.println("binary tree constructed.");
        System.out.println("INPUT:");
        List<BTNode> input = BinaryTreeInOrderTraversal.inOrderTraversal(root1);
        input.stream().forEach(node -> System.out.print(node.data + " "));

        BTNode outputNode = invertTree(root1);

        System.out.println("\n\nOUTPUT:");
        List<BTNode> result = BinaryTreeInOrderTraversal.inOrderTraversal(outputNode);
        result.stream().forEach(node -> System.out.print(node.data + " "));
    }
}