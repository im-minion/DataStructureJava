package rotations;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] Arr = {1, 2, 3, 4, 5, 6, 7};
        int[] newArr = rotateArray(Arr, 2);
        Arrays.stream(newArr).boxed().forEach(System.out::println);
    }

    private static int[] rotateArray(int[] arr, int d) {
        int n = arr.length;
        int j = 0;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++, d++) {
            if (d < n) {
                newArr[i] = arr[d];
            } else {
                newArr[i] = arr[j];
                j++;
            }
        }
        return newArr;
    }
//    public static void rotate(int[] nums, int k) {
//
//        for(int i = 0 ; i <= k ; i++)
//            leftRotateByOne(nums);
//
//    }
//    public static void leftRotateByOne(int[] nums) {
//        int temp = nums[0];
//        int i = 0;
//        for(; i< nums.length - 1; i++)  {
//            nums[i] = nums[i+1];
//        }
//        nums[i] = temp;
//    }
}
