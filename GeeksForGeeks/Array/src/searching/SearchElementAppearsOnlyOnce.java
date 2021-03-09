package searching;

/*
TODO: XOR
Find the element that appears once in an array where every other element appears twice
Difficulty Level : Easy

Given an array of integers. All numbers occur twice except one number which occurs once. Find the number in O(n) time & constant extra space.
Example :


Input:  ar[] = {7, 3, 5, 4, 5, 3, 4}
Output: 7


Let us consider the above example.
Let ^ be xor operator as in C and C++.

res = 7 ^ 3 ^ 5 ^ 4 ^ 5 ^ 3 ^ 4

Since XOR is associative and commutative, above
expression can be written as:
res = 7 ^ (3 ^ 3) ^ (4 ^ 4) ^ (5 ^ 5)
    = 7 ^ 0 ^ 0 ^ 0
    = 7 ^ 0
    = 7


*/

public class SearchElementAppearsOnlyOnce {
    public static void main(String[] args) {

        int ar[] = {2, 3, 5, 4, 5, 3, 4};
        int n = ar.length;
        System.out.println("Element occurring once is " +
                findSingle(ar) + " ");
    }

    private static int findSingle(int[] arr) {
        int res = arr[0];
        for (int i = 1; i < arr.length; i++) {
            res = res ^ arr[i];
        }

        return res;
    }
}
