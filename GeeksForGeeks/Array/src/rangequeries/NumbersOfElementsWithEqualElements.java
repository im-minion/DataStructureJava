package rangequeries;

/*
Number of indexes with equal elements in given range
Difficulty Level : Medium

Given N numbers and Q queries, every query consists of L and R,
task is to find the number of such integers i (L<=i<R) such that Ai=Ai+1. Consider 0-based indexing.

Examples :

Input : A = [1, 2, 2, 2, 3, 3, 4, 4, 4]
Q = 2
L = 1 R = 8
L = 0 R = 4
Output : 5
2
Explanation: We have 5 index i which has Ai=Ai+1 in range [1, 8). We have 2 indexes i which have Ai=Ai+1 in range [0, 4).

Input :A = [3, 3, 4, 4]
Q = 2
L = 0 R = 3
L = 2 R = 3
Output : 2
1
*/
public class NumbersOfElementsWithEqualElements {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 2, 3, 3, 4, 4, 4};
        int n = a.length;

        // 1-st query
        int L, R;
        L = 1;
        R = 8;

        System.out.println(answerQuery(a, n, L, R));

        // 2nd query
        L = 0;
        R = 4;
        System.out.println(answerQuery(a, n, L, R));
    }

    private static int answerQuery(int[] arr, int n, int l, int r) {
        int count = 0;
        for (int i = l; i < r; i++) {
            if (arr[i] == arr[i + 1]) {
                count++;
            }
        }
        return count;
    }
}
