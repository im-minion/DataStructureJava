package gfg.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {5, 4, 7},
                {1, 3, 8},
                {2, 9, 6}
        };
        sortMatrix(arr);
        MatrixUtil.printMatrix(arr);
    }

    private static void sortMatrix(int[][] arr) {
        //extra space O(n2)
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                temp.add(arr[i][j]);
            }
        }
        // time O(nLogn)
        Collections.sort(temp);
        int count = 0;
        // time O(n2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = temp.get(count);
                count++;
            }
        }
    }
}
