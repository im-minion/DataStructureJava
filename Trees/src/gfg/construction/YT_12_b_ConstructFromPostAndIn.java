package gfg.construction;

import gfg.introduction.BinaryTree;
import gfg.introduction.Node;

// Verified
public class YT_12_b_ConstructFromPostAndIn {
    public static void main(String[] args) {
        int[] post = {6, 2, 4, 5, 3, 1};

        int[] in = {6, 2, 1, 4, 3, 5};

        Node r = buildTreeFromPostAndIn(post, in);

        BinaryTree.printBFS(r);
    }

    private static Node buildTreeFromPostAndIn(int[] post, int[] in) {
        return build(post, in, post.length - 1, 0, in.length - 1);
    }

    private static Node build(int[] post, int[] in, int postIndex, int inStart, int inEnd) {

        if (inStart > inEnd) return null;

        Node root = new Node(post[postIndex]);
        int mid = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.key) {
                mid = i;
                break;
            }
        }
        postIndex--;
        root.left = build(post, in, postIndex - (inEnd - mid), inStart, mid - 1);
        root.right = build(post, in, postIndex, mid + 1, inEnd);

        return root;
    }
}
