package construction;

import introduction.BinaryTree;
import introduction.Node;

import java.util.ArrayList;
import java.util.List;

// Verified
public class YT_14_a_SerializationDeSerialization {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        System.out.println("Actual Inorder :");
        BinaryTree.printInorderTraversal(tree.root);
        System.out.println();

        /*Serialize*/
        List<Integer> op = new ArrayList<>();
        serialize(tree.root, op);
        System.out.println("Serialized : \n" + op);

        /*DeSerialize*/
        MyKlass myKlass = new MyKlass();
        Node node = deSerialize(op, myKlass);
        System.out.println("De-Serialized : ");
        BinaryTree.printInorderTraversal(node);
    }

    private static void serialize(Node root, List<Integer> op) {
        if (root == null) {
            op.add(-1);
            return;
        }
        op.add(root.key);
        serialize(root.left, op);
        serialize(root.right, op);
    }

    private static Node deSerialize(List<Integer> op, MyKlass myKlass) {
        if (op.get(myKlass.pos) == -1) {
            return null;
        } else {
            Node t = new Node(op.get(myKlass.pos));
            myKlass.pos++;
            t.left = deSerialize(op, myKlass);
            myKlass.pos++;
            t.right = deSerialize(op, myKlass);
            return t;
        }
    }

    private static class MyKlass {
        int pos = 0;
    }


}
