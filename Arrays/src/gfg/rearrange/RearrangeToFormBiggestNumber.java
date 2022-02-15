package gfg.rearrange;

/*
Given an array of numbers, arrange them in a way that yields the largest value. For example,
if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value.
And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
*/

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RearrangeToFormBiggestNumber {
    public static void main(String[] args) {
        String[] arr = {"54", "546", "548", "60"};
        String op = rearrange(arr);
        System.out.println(op);
    }

    private static String rearrange(String[] arr) {
        List<String> list = Arrays.stream(arr).sorted((X, Y) -> {
            String XY = X + Y;

            // then append X at the end of Y
            String YX = Y + X;

            // Now see which of the two
            // formed numbers
            // is greater
            if (XY.equals(YX)) {
                return 0;
            }
            return XY.compareTo(YX) > 0 ? -1 : 1;
        }).collect(Collectors.toList());
        return list.stream().reduce("", (a, b) -> a + b);
    }
}
