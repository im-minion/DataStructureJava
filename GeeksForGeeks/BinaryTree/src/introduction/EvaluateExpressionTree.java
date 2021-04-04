package introduction;

public class EvaluateExpressionTree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        /* The constructed binary tree is
             1
           /   \
          2     3
           \    /
            4  5
        */
        tree.root = new Node('+');
        tree.root.left = new Node('*');
        tree.root.right = new Node('-');

        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(4);

        tree.root.right.left = new Node(100);
        tree.root.right.right = new Node(20);
        System.out.println("Output : " + evaluateExpression(tree.root));

    }

    private static int evaluateExpression(Node root) {
        // base cond
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.key;

        // recursive cond
        int leftVal = evaluateExpression(root.left);
        int rightVal = evaluateExpression(root.right);

        // returning cond
        if ((char) root.key == '-') {
            return leftVal - rightVal;
        }
        if ((char) root.key == '+') {
            return leftVal + rightVal;
        }
        if ((char) root.key == '*') {
            return leftVal * rightVal;
        }
        if ((char) root.key == '/') {
            return leftVal / rightVal;
        }
        return -1;
    }

}
