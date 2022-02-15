package gfg.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class YT_10_c_PreOrderToPostOrderInBST {
    public static void main(String[] args) {
        int[] pre = new int[]{40, 30, 35, 80, 100};
        List<Integer> post = solve(pre, pre.length);
        System.out.println(post);
    }

    private static List<Integer> solve(int[] pre, int length) {
        List<Integer> op = new ArrayList<>(length);
        preToPost(pre, op, 0, length - 1);
        return op;
    }

    private static void preToPost(int[] pre, List<Integer> op, int l, int r) {
        if (l > r) return;
        int g = findNextGreaterIndex(pre, l, r);

        //left
        preToPost(pre, op, l + 1, g - 1);

        //right
        preToPost(pre, op, g, r);

        //node
        op.add(pre[l]);
    }

    private static int findNextGreaterIndex(int[] pre, int l, int r) {
        int c = pre[l];
        int i;
        for (i = l; i <= r; i++) {
            if (pre[i] > c) {
                return i;
            }
        }
        return i;
    }

}
