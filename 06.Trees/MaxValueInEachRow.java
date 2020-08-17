import java.util.ArrayList;
import java.util.List;

public class MaxValueInEachRow {
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

        List<Integer> outputNode = getMaxInEachRow(root1);

        System.out.println("\n\nOUTPUT:");
        outputNode.stream().forEach(op -> System.out.print(op + " "));
    }

    private static List<Integer> getMaxInEachRow(BTNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        result.add(root.data);
        maxValue(root, result, 0);
        return result;
    }

    private static void maxValue(BTNode node, List<Integer> result, int level) {
        // termination condition
        if (node == null)
            return;
        // operation to perform
        if (result.size() == level) {
            result.add(node.data);
        } else {
            result.set(level, Math.max(result.get(level), node.data));
        }

        // recursion for left and right of node
        maxValue(node.left, result, level + 1);
        maxValue(node.right, result, level + 1);

    }
}