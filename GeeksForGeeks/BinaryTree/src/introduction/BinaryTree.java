package introduction;

public class BinaryTree {

    public Node root;

    BinaryTree(int data) {
        this.root = new Node(data);
    }

    BinaryTree() {
        this.root = null;
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree(2);
        binaryTree.root.left = new Node(3);
        binaryTree.root.right = new Node(4);

        binaryTree.root.left.left = new Node(33);
        binaryTree.root.left.right = new Node(34);
    }
}
