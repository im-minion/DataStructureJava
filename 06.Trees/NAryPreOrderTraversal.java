import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NAryPreOrderTraversal {
    public static List<Integer> preorder(TreeNode root) {
        // push order to stack should be opposite
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        if (root == null)
            return result;
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            result.add(currNode.data);
            List<TreeNode> children = currNode.children;
            Collections.reverse(children);
            if (children != null) {
                for (TreeNode n : children) {
                    stack.push(n);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        List<TreeNode> children = new ArrayList<>();

        for (int i = 2; i < 10; i++) {
            TreeNode node = new TreeNode(i);
            children.add(node);
        }
        root.children = children;

        List<Integer> result = preorder(root);

        for (int i : result) {
            System.out.print(i + " ");
        }

    }
}