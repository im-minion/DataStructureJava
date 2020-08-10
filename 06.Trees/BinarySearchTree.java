public class BinarySearchTree {

    private BSTNode root;

    public boolean isEmpty() {
        return this.root == null;
    }

    private BSTNode search(int item) {
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

    private BSTNode search(BSTNode node, int item) {
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

    private void remove(int i) {
    }

    private void insert(int item) {
        if (isEmpty()) {
            this.root = new BSTNode(item);
            return;
        }
        if (item < this.root.data) {
            this.root.left = insert(this.root.left, item);
        } else {
            this.root.right = insert(this.root.right, item);
        }
    }

    private BSTNode insert(BSTNode node, int item) {
        if (node == null) {
            return new BSTNode(item);
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
        binarySearchTree.insert(10);
        System.out.println("Inserted " + 10);
        binarySearchTree.insert(50);
        System.out.println("Inserted " + 50);
        binarySearchTree.insert(100);
        System.out.println("Inserted " + 100);
        binarySearchTree.insert(85);
        System.out.println("Inserted " + 85);
        binarySearchTree.insert(60);
        System.out.println("Inserted " + 60);

        System.out.println("Search 60");
        System.out.println("Found " + binarySearchTree.search(60));
        System.out.println("Search 40");
        System.out.println("Found " + binarySearchTree.search(40));

        System.out.println("Remove " + 60);
        binarySearchTree.remove(60);
        System.out.println("Search 60");
        System.out.println("Found " + binarySearchTree.search(60));

        System.out.println("Remove " + 55);
        binarySearchTree.remove(55);
        System.out.println("Search 55");
        System.out.println("Found " + binarySearchTree.search(55));
    }

}