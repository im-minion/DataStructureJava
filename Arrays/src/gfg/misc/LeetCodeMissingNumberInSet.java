package gfg.misc;

import java.util.Arrays;

public class LeetCodeMissingNumberInSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 4};
        int[] t = findErrorNums(arr);
        Arrays.stream(t).forEach(System.out::print);
    }

    public static int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        int i = 0;
        int j = nums[0];
        int n = nums.length;
        while (i < n) {
            if (nums[i] != (j)) {
                break;
            } else {
                i++;
                j++;
            }
        }
        result[0] = j - 1;
        result[1] = j;

        return result;
    }
}

