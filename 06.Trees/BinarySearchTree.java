public class BinarySearchTree {

    public BTNode root;

    public boolean isEmpty() {
        return this.root == null;
    }

    private BTNode search(int item) {
        if (isEmpty()) {
            throw new IllegalStateException("Can't perform Search operation on empty Tree!");
        }
        if (this.root.data == item) {
            return this.root;
        } else if (item < this.root.data) {
            return search(this.root.left, item);
        } else {
            return search(this.root.right, item);
        }
    }

    private BTNode search(BTNode node, int item) {
        if (node == null) {
            return null;
        }
        if (node.data == item) {
            return node;
        } else if (item < node.data) {
            return search(node.left, item);
        } else {
            return search(node.right, item);
        }
    }

    public BTNode remove(BTNode node, int item) {
        if (node == null) {
            return null;
        }

        if (isEmpty()) {
            throw new IllegalStateException("Can't perform Search operation on empty Tree!");
        }

        if (node.data > item) {

            node.left = remove(node.left, item);

        } else if (node.data < item) {

            node.right = remove(node.right, item);

        } else {

            // we have found the node that we want to remove.

            if (node.left == null) {

                node = node.right;
            } else if (node.right == null) {

                node = node.left;
            } else {

                node.data = digRight(node.right);
                node.right = remove(node.right, item);
            }

        }

        return node;
    }

    private int digRight(BTNode right) {
        // Dig as far left as possible to get the smallest value from the right subtree.
        BTNode current = right;
        while (current.left != null) {

            current = current.left;
        }

        return current.data;
    }

    public void insert(int item) {
        if (isEmpty()) {
            this.root = new BTNode(item);
            return;
        }
        if (item < this.root.data) {
            this.root.left = insert(this.root.left, item);
        } else {
            this.root.right = insert(this.root.right, item);
        }
    }

    private BTNode insert(BTNode node, int item) {
        if (node == null) {
            return new BTNode(item);
        } else if (item < node.data) {
            node.left = insert(node.left, item);
        } else {
            node.right = insert(node.right, item);
        }
        return node;
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

        System.out.println("Search 90");
        System.out.println("Found " + binarySearchTree.search(90));
        System.out.println("Search 25");
        System.out.println("Found " + binarySearchTree.search(25));

        System.out.println("Remove " + 10);
        System.out.println(binarySearchTree.remove(binarySearchTree.root, 10));
        System.out.println("Search 10");
        System.out.println("Found " + binarySearchTree.search(10));

        System.out.println("Remove " + 90);
        System.out.println(binarySearchTree.remove(binarySearchTree.root, 90));
        System.out.println("Search 90");
        System.out.println("Found " + binarySearchTree.search(90));

        System.out.println("Remove " + 10);
        System.out.println(binarySearchTree.remove(binarySearchTree.root, 10));
        System.out.println("Search 10");
        System.out.println("Found " + binarySearchTree.search(10));
    }

}