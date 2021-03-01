import java.util.Arrays;

/*
    Rearrange positive and negative numbers using inbuilt sort function
    Difficulty Level : Medium
    Given an array of positive and negative numbers, arrange them such that
    all negative integers appear before all the positive integers in the array without using any additional data structure like
    a hash table, arrays, etc. The order of appearance should be maintained.
    Examples:

    Input :  arr[] = [12, 11, -13, -5, 6, -7, 5, -3, -6]
    Output : arr[] = [-13, -5, -7, -3, -6, 12, 11, 6, 5]

    Input :  arr[] = [-12, 11, 0, -5, 6, -7, 5, -3, -6]
    Output : arr[] =  [-12, -5, -7, -3, -6, 0, 11, 6, 5]
*/
public class RearrangePosNeg {
    public static void main(String[] args) {
        int[] arr = {-12, 11, 0, -5, 6, -7, 5, -3, -6};
        reArrangeWithSingleTraversal(arr);
        Arrays.stream(arr).boxed().forEach(System.out::print);
    }

    // o(n) , single traversal;
    private static void reArrangeWithSingleTraversal(int[] arr) {
        int n = arr.length;
        int i = 0;
        int lastNonZeroIndex = -1;

        while (i < n) {
            if (arr[i] < 0) {
                lastNonZeroIndex++;
                int t = arr[lastNonZeroIndex];
                arr[lastNonZeroIndex] = arr[i];
                arr[i] = t;
            }
            i++;
        }
    }
}
