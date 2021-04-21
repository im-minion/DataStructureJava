package construction;

import introduction.BinaryTree;
import introduction.Node;

import java.util.Arrays;

// TODO: failing
public class YT_12_c_ConstructFromInAndLevelOrder {
    public static void main(String[] args) {

        int[] in = new int[]{4, 8, 10, 12, 14, 20, 22};
        int[] level = new int[]{20, 8, 22, 4, 12, 10, 14};
        Node node = buildTree(in, level);

        /* Let us test the built tree by printing Inorder
         * traversal */
        System.out.print("Inorder traversal of the constructed tree is ");
        BinaryTree.printInorderTraversal(node);
    }

    private static Node buildTree(int[] in, int[] level) {
        return build(in, level);
    }

    private static Node build(int[] in, int[] level) {
        if (in.length == 0 || level.length == 0) return null;

        Node root = new Node(level[0]);
        int mid = search(in, level[0]);

        int[] leftIn = mid != 0 ? find(in, 0, mid - 1) : new int[]{};

        int[] rightIn = mid != in.length ? find(in, mid + 1, in.length - 1) : new int[]{in[0]};

        int[] vDash = mid != 0 ? Arrays.copyOfRange(level, 0, mid - 1) : new int[]{};
        int[] vDashDash = mid != level.length ? Arrays.copyOfRange(level, mid + 1, level.length - 1) : new int[]{level[0]};

        root.left = build(vDash, leftIn);

        root.right = build(vDashDash, rightIn);

        return root;
    }

    private static int[] find(int[] arr, int from, int to) {
        int[] t = new int[to - from + 1];
        int j = 0;
        for (int i = from; i <= to; i++) {
            t[j++] = arr[i];
        }
        return t;
    }

    private static int search(int[] in, int key) {
        int x;
        for (x = 0; x < in.length; x++) {
            if (in[x] == key)
                return x;
        }
        return x;
    }
}
