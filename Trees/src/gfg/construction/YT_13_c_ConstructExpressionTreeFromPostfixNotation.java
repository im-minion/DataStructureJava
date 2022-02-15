package gfg.construction;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

// Verified
public class YT_13_c_ConstructExpressionTreeFromPostfixNotation {
    static int curr = 0;

    public static void main(String[] args) {
        char[] a = "ab-c+de/*".toCharArray();
        curr = a.length - 1;
        MyKlass myKlass = new MyKlass();
        myKlass.pos = a.length - 1;
        Node op = solve(a, myKlass);
        BinaryTree.printCharInorderTraversal(op);
    }

    private static Node solve(char[] a, MyKlass myKlass) {
        if (myKlass.pos < 0) return null;
        Node root = new Node(a[myKlass.pos]);

        if (a[myKlass.pos] == '+' || a[myKlass.pos] == '-' || a[myKlass.pos] == '*' || a[myKlass.pos] == '/' || a[myKlass.pos] == '^') {
            myKlass.pos--;
            root.right = solve(a, myKlass);
            myKlass.pos--;
            root.left = solve(a, myKlass);
        }
        return root;
    }

    private static class MyKlass {
        int pos;
    }

    /*Alternate approach*/
    private static Node solve(char[] a) { //
        if (curr < 0) return null;
        Node root = new Node(a[curr]);
        if (a[curr] == '+' || a[curr] == '-' || a[curr] == '*' || a[curr] == '/' || a[curr] == '^') {
            curr--;
            root.right = solve(a);
            curr--;
            root.left = solve(a);
        }
        return root;
    }
}
