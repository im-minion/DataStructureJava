package gfg.height;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;


// Verified solution with geeks for geeks
public class YT_02_IsBalanced {
    public static void main(String[] args) {
        /*Node Insertion*/
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        boolean op = isBalancedTree(tree.root);
        System.out.println(op);
    }

    private static boolean isBalancedTree(Node root) {
        if (root == null) return true;
        MyObj myObj = new MyObj();
        height(root, myObj);
        return myObj.op;
    }

    private static int height(Node root, MyObj isBalanced) {

        if (root == null)
            return 0;


        int leftHeight = height(root.left, isBalanced);

        int rightHeight = height(root.right, isBalanced);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            isBalanced.op = false;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }
}

class MyObj { //TODO: IMP -> REMEMBER ->  just to use the pass by reference thing, we have to create a class!!!!
    boolean op = true;
}