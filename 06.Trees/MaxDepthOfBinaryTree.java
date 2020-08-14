public class MaxDepthOfBinaryTree {

    public static int maxDepth(BTNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        System.out.println("Creating binary search tree.");
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        System.out.println("Insert into the tree.");
        binarySearchTree.insert(50);
        System.out.println("Inserted " + 50);
        binarySearchTree.insert(20);
        System.out.println("Inserted " + 20);
        binarySearchTree.insert(80);
        System.out.println("Inserted " + 80);
        binarySearchTree.insert(10);
        System.out.println("Inserted " + 10);
        binarySearchTree.insert(25);
        System.out.println("Inserted " + 25);
        binarySearchTree.insert(5);
        System.out.println("Inserted " + 5);
        binarySearchTree.insert(23);
        System.out.println("Inserted " + 23);
        binarySearchTree.insert(90);
        System.out.println("Inserted " + 90);
        binarySearchTree.insert(85);
        System.out.println("Inserted " + 85);
        binarySearchTree.insert(87);
        System.out.println("Inserted " + 87);
        binarySearchTree.insert(27);
        System.out.println("Inserted " + 27);

        System.out.println(maxDepth(binarySearchTree.root));
    }

}