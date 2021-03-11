package searching;

/*
Find subarray with given sum | Set 1 (Nonnegative Numbers)
Difficulty Level : Medium
Given an unsorted array of nonnegative integers, find a continuous subarray which adds to a given number.
Examples :

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4
Sum of elements between indices
2 and 4 is 20 + 3 + 10 = 33

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4
Sum of elements between indices
1 and 4 is 4 + 0 + 0 + 3 = 7

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There is no subarray with 0 sum
There may be more than one subarrays with sum as the given sum. The following solutions print first such subarray.
*/
public class SubArrayWithGivenSum {
    public static void main(String[] args) {

        int[] arr = {15, 2, 4, 8, 9, 5, 10, 23};
        int n = arr.length;
        int sum = 23;
        int[] op = subArraySum(arr, n, sum);
        System.out.println("start : " + op[0]);
        System.out.println("end : " + op[1]);
    }

    private static int[] subArraySum(int[] arr, int n, int sum) {
        int[] op = new int[2];
        int i = 0;
        int j = 0;
        int currSum = 0;
        while (j < n) {
            currSum += arr[j];
            if (currSum == sum) {
                op[0] = i;
                op[1] = j;
                break;
            } else if (currSum < sum) {
                j++;
            } else if (currSum > sum) {
                while (currSum > sum) {
                    currSum -= arr[i];
                    i++;
                }
                if (currSum == sum) {
                    op[0] = i;
                    op[1] = j;
                    break;
                }
                j++;
            }
        }
        return op;
    }
}
