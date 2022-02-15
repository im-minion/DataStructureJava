package gfg.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class YT_10_d_PostOrderToPreOrderInBST {
    public static void main(String[] args) {
        int[] post = new int[]{100, 80, 35, 30, 40};
        List<Integer> pre = solve(post, post.length);
        System.out.println(pre);
    }

    private static List<Integer> solve(int[] post, int length) {
        List<Integer> op = new ArrayList<>(length);
        postToPre(post, op, 0, length - 1);
        return op;
    }

    private static void postToPre(int[] post, List<Integer> op, int l, int r) {
        if (l > r) return;

        // node
        op.add(post[r]);

        int s = findNextSmallerIndex(post, l, r);
        // left
        postToPre(post, op, l, s);

        // right
        postToPre(post, op, s + 1, r - 1);


    }

    private static int findNextSmallerIndex(int[] pre, int l, int r) {
        int c = pre[r];
        int i;
        for (i = r; i >= l; i--) {
            if (pre[i] < c) {
                return i;
            }
        }
        return i;
    }
}
