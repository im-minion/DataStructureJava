package gfg.construction;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

public class YT_13_b_ConstructExpressionTreeFromPrefixNotation {
    static int curr = 0;

    public static void main(String[] args) {
        char[] a = "*+34/76".toCharArray();
        Node op = solve(a);
        BinaryTree.printCharInorderTraversal(op);
    }

    private static Node solve(char[] a) {
        if (curr == a.length) return null;
        Node root = new Node(a[curr]);
        if (a[curr] == '+' || a[curr] == '-' || a[curr] == '*' || a[curr] == '/') {
            // operator
            curr++;
            root.left = solve(a);
            curr++;
            root.right = solve(a);
        }

        return root;
    }
}
