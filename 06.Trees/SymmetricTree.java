public class SymmetricTree {

    private static boolean isSymmetricTree(BSTNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricSides(root.left, root.right);
    }

    private static boolean isSymmetricSides(BSTNode left, BSTNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.data == right.data) {
            return isSymmetricSides(left.left, right.right) && isSymmetricSides(left.right, right.left);
        }
        return false;
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

        System.out.println(isSymmetricTree(binarySearchTree.root));

        BinarySearchTree binarySearchTree2 = new BinarySearchTree();

        System.out.println("Insert into the tree.");
        binarySearchTree.insert(1);
        System.out.println("Inserted " + 1);
        binarySearchTree.insert(2);
        System.out.println("Inserted " + 2);
        binarySearchTree.insert(2);
        System.out.println("Inserted " + 2);
        binarySearchTree.insert(3);
        System.out.println("Inserted " + 3);
        binarySearchTree.insert(4);
        System.out.println("Inserted " + 4);
        binarySearchTree.insert(4);
        System.out.println("Inserted " + 4);
        binarySearchTree.insert(3);
        System.out.println("Inserted " + 3);

        System.out.println(isSymmetricTree(binarySearchTree2.root));
    }
}