package gfg.orderstatistics;

import java.util.ArrayList;
import java.util.List;

/*
TODO: Understand this shit
16. K maximum sums of non-overlapping contiguous sub-arrays
 */
public class KMaxSumsNonOverlappingContiguousSubArray {
    public static void main(String[] args) {
        int[] arr = {4, 1, 1, -1, -3, -5, 6, 2, -6, -2};
        int k = 3;
        List<Integer> op = getResult(arr, k);
        System.out.println(op);
    }

    private static List<Integer> getResult(int[] arr, int k) {
        List<Integer> op = new ArrayList<>();
//        Tried the sliding window but failed
        return op;
    }
}
