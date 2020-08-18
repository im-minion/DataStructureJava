import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class NAryPostOrderTraversal {
    public static void main(String[] args) {
        System.out.println("N-Ary Trees Post order traversal.");
        TreeNode root = new TreeNode(1);
        List<TreeNode> children = new ArrayList<>();

        for (int i = 2; i < 10; i++) {
            TreeNode node = new TreeNode(i);
            children.add(node);
        }
        root.children = children;

        List<Integer> result = postOrder(root);

        for (int i : result) {
            System.out.print(i + " ");
        }

    }

    private static List<Integer> postOrder(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null)
            return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode currNode = stack.pop();
            result.offerFirst(currNode.data);
            if (currNode.children != null) {
                for (TreeNode n : currNode.children) {
                    stack.push(n);
                }
            }
        }
        return result;
    }
}