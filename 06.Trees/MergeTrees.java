public class MergeTrees {
    public static void main(String[] args) {
        BTNode root1 = createTree();
        BTNode root2 = createTree();
        BTNode mergedTree = mergeTrees(root1, root2);

        BinaryTreeInOrderTraversal.inOrderTraversal(mergedTree).forEach(op -> System.out.print(op + " "));
    }

    public static BTNode mergeTrees(BTNode t1, BTNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }

        t1.data = t1.data + t2.data;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);

        return t1;
    }

    public static BTNode createTree() {
        System.out.println("Creating a tree.");
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);
        System.out.println("Tree constructed.");
        return root;
    }
}