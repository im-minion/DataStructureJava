package construction;

import introduction.BinaryTree;
import introduction.Node;

public class YT_12_a_ConstructFromInAndPre {
    public static void main(String[] args) {

        int[] pre = new int[]{3, 9, 20, 15, 7};

        int[] in = new int[]{9, 3, 15, 20, 7};

        Node root = buildTreeFromInPre(pre, in);

        BinaryTree.printBFS(root);
    }

    private static Node buildTreeFromInPre(int[] pre, int[] in) {
        return build(pre, in, 0, 0, pre.length - 1);
    }

    private static Node build(int[] pre, int[] in, int preStart, int inStart, int inEnd) {
        if (preStart > pre.length - 1 || inStart > inEnd) {
            return null;
        }

        Node root = new Node(pre[preStart]);

        int mid = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (root.key == in[i]) {
                mid = i;
            }
        }

        preStart++;

        root.left = build(pre, in, preStart, inStart, mid - 1);

        root.right = build(pre, in, preStart + (mid - inStart), mid + 1, inEnd);

        return root;
    }
}
