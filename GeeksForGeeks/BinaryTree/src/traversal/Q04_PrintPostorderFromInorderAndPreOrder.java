package traversal;

import java.util.Arrays;

public class Q04_PrintPostorderFromInorderAndPreOrder {
    public static void main(String[] args) {
        int[] in1 = {4, 2, 5, 1, 3, 6};
        int[] pre = {1, 2, 4, 5, 3, 6};
        int n = in1.length;
        System.out.println("Postorder traversal ");
        printPostOrder(in1, pre, n);
    }

    private static void printPostOrder(int[] inorder, int[] preorder, int n) {
        int rootIndexPre = 0;
        int rootIndexInorder = getElementIndex(inorder, preorder[rootIndexPre], n);

        if (rootIndexInorder != 0) {
            // left subtree exists
            printPostOrder(inorder, Arrays.copyOfRange(preorder, 1, n), rootIndexInorder);
        }

        if (rootIndexInorder != n - 1) {
            // right subtree exists
            printPostOrder(
                    // shorten inorder array
                    Arrays.copyOfRange(inorder, rootIndexInorder + 1, n),
                    // shorten preorder array
                    Arrays.copyOfRange(preorder, 1 + rootIndexInorder, n),
                    n - rootIndexInorder - 1
            );
        }

        System.out.print(preorder[0] + "  ");
    }

    static int getElementIndex(int[] arr, int x, int n) {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }

}
