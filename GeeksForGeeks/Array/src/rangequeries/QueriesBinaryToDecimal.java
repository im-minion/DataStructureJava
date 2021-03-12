package rangequeries;

/*

Queries for decimal values of subarrays of a binary array
Difficulty Level : Medium

Given a binary array arr[], we to find the number represented by the subarray a[l..r]. There are multiple such queries.

Examples:

Input :  arr[] = {1, 0, 1, 0, 1, 1};
l = 2, r = 4
l = 4, r = 5
Output :
5
3

Subarray 2 to 4 is 101 which is 5 in decimal.
Subarray 4 to 5 is 11 which is 3 in decimal.

Input : arr[] = {1, 1, 1}
l = 0, r = 2
l = 1, r = 2
Output :
7
3
*/
public class QueriesBinaryToDecimal {
    public static void main(String[] args) {
        int arr[] = {1, 0, 1, 0, 1, 1};
        int n = arr.length;
        int r = decimalOfSubArray(arr, 2, 4, n);
        System.out.println(r);

        System.out.println(decimalOfSubArray(arr, 4, 5, n));
    }

    private static int decimalOfSubArray(int[] arr, int start, int end, int n) {
        int r = 0;
        int multiplier = 0;
        for (int i = end; i >= start; i--) {
            if (arr[i] == 1)
                r = (int) (r + Math.pow(2, multiplier));
            multiplier++;
        }
        return r;
    }
}
