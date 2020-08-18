/**
 * 
 * Range Sum of BST
 * 
 * Given the root node of a binary search tree, return the sum of values of all
 * nodes with value between L and R (inclusive).
 * 
 * The binary search tree is guaranteed to have unique values.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15 Output: 32 Example 2:
 * 
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10 Output: 23
 * 
 * 
 * Note:
 * 
 * The number of nodes in the tree is at most 10000. The final answer is
 * guaranteed to be less than 2^31.
 */

public class RangeSumBST {

    static int sum = 0;

    public static int rangeSumBST(BTNode root, int L, int R) {
        if (root == null)
            return 0;
        if (root.data >= L && root.data <= R)
            sum = sum + root.data;
        if (root.data > L)
            rangeSumBST(root.left, L, R);
        if (root.data < R)
            rangeSumBST(root.right, L, R);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Construct a bst");
        BTNode root = new BTNode(20);
        root.left = new BTNode(10);
        root.right = new BTNode(30);
        root.left.left = new BTNode(5);
        root.left.right = new BTNode(15);
        root.right.left = new BTNode(25);
        root.right.right = new BTNode(40);
        System.out.println("bst constructed.");
        int sum = rangeSumBST(root, 5, 10);
        System.out.println("Range sum of bst is " + sum);
    }
}