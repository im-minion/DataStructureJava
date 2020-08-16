import java.util.Stack;

public class FlattenLeetCode {
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
        flatten(root1);
    }

    public static void flatten(BTNode root) {
        doFlatten(root);
    }

    public static BTNode doFlatten(BTNode node) {
        if (node == null)
            return node;
        Stack<BTNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            node = stack.pop();
            if (node.right != null)
                stack.push(node.right);
            if (node.left != null)
                stack.push(node.left);
            if (!stack.isEmpty())
                node.right = stack.peek();
            node.left = null;
        }
        return node;
    }
}