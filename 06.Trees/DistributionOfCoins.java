/**
 * 
 * Distribute Coins in Binary Tree
 * 
 * 
 * Given the root of a binary tree with N nodes, each node in the tree has
 * node.val coins, and there are N coins total.
 * 
 * In one move, we may choose two adjacent nodes and move one coin from one node
 * to another. (The move may be from parent to child, or from child to parent.)
 * 
 * Return the number of moves required to make every node have exactly one coin.
 */

public class DistributionOfCoins {
    static int numMoves;

    public static void main(String[] args) {
        System.out.println("Construct a binary tree");
        BTNode root1 = new BTNode(20);
        root1.left = new BTNode(10);
        root1.right = new BTNode(30);
        root1.left.left = new BTNode(5);
        root1.left.right = new BTNode(15);
        root1.right.left = new BTNode(25);
        root1.right.right = new BTNode(40);
        System.out.println("binary tree constructed.");
        int moves = distributeCoins(root1);
        System.out.println("Number of moves to evenly distribute coins: " + moves);

        BTNode test2 = new BTNode(3);
        test2.left = new BTNode(0);
        test2.right = new BTNode(0);
        System.out.println("\n\n TEST 2: \nNumber of moves to evenly distribute coins: " + distributeCoins(test2));

        BTNode test3 = new BTNode(1);
        test3.left = new BTNode(0);
        test3.right = new BTNode(0);
        test3.left.right = new BTNode(3);
        System.out.println("\n\n TEST 3: \nNumber of moves to evenly distribute coins: " + distributeCoins(test3));
    }

    private static int distributeCoins(BTNode root) {
        numMoves = 0;
        distribute(root);
        return numMoves;
    }

    private static int distribute(BTNode node) {
        if (node == null)
            return 0;
        int leftCount = distribute(node.left);
        int rightCount = distribute(node.right);
        numMoves += Math.abs(leftCount) + Math.abs(rightCount);
        return leftCount + rightCount + node.data - 1;
    }
}