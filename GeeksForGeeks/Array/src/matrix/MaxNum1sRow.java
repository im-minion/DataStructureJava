package matrix;

/*
Find the row with maximum number of 1s
Difficulty Level : Medium

Given a boolean 2D array, where each row is sorted. Find the row with the maximum number of 1s.
Example:


Input matrix
0 1 1 1
0 0 1 1
1 1 1 1  // this row has maximum 1s
0 0 0 0

Output: 2
*/
public class MaxNum1sRow {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1},
                {0, 0, 0, 0}
        };
        int rowNo = maxNumOnes(arr);
        System.out.println(rowNo);
    }

    private static int maxNumOnes(int[][] arr) {
        int maxOnes = 0;
        int resultRow = -1;
        for (int i = 0; i < arr.length; i++) {
            int currRowOnes = 0;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 1) {
                    currRowOnes++;
                }
            }
            if (currRowOnes > maxOnes) {
                maxOnes = currRowOnes;
                resultRow = i;
            }
        }
        return resultRow;
    }
}
