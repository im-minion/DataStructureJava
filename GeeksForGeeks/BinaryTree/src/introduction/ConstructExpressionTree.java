package introduction;

import java.util.Stack;

class NodeChar extends Node {
    public NodeChar(char item) {
        super(item);
    }
}

public class ConstructExpressionTree {
    public static void main(String[] args) {
        String postfix = "ab+ef*g*-";
        char[] charArray = postfix.toCharArray();
        NodeChar root = constructTree(charArray);

        BinaryTree.printCharInorderTraversal(root);
    }

    private static NodeChar constructTree(char[] ip) {
        Stack<NodeChar> stack = new Stack<>();
        NodeChar n1, n2, n;

        for (int i = 0; i < ip.length; i++) {
            if (!(ip[i] == '*' || ip[i] == '/' || ip[i] == '+' || ip[i] == '-' || ip[i] == '^')) {
                n = new NodeChar(ip[i]);
                stack.push(n);
            } else {
                n = new NodeChar(ip[i]);

                n1 = stack.pop();
                n2 = stack.pop();

                n.right = n1;
                n.left = n2;

                stack.push(n);
            }
        }

        n = stack.peek();
        stack.pop();
        return n;
    }
}
