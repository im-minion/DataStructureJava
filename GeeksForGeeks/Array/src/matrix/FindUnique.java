package matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Find unique elements in a matrix
Difficulty Level : Basic

Given a matrix mat[][] having n rows and m columns.
We need to find unique elements in matrix i.e,
those elements which are not repeated in the matrix or those elements whose frequency is 1.

Examples:

Input :
20  15  30  2
2   3   5   30
6   7   6   8
Output :
3  20  5  7  8  15

Input :
 1  2  3
5  6  2
1  3  5
6  2  2
Output : No unique element in the matrix
*/
public class FindUnique {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 20},
                {5, 6, 20, 25},
                {1, 3, 5, 6},
                {6, 7, 8, 15}
        };

        // function that calculate unique element
        List<Integer> op = unique(mat);
        System.out.println(op);
    }

    private static List<Integer> unique(int[][] arr) {
        List<Integer> op = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (null == map.get(arr[i][j])) {
                    map.put(arr[i][j], 1);
                } else {
                    map.put(arr[i][j], map.get(arr[i][j]) + 1);
                }
            }
        }
        for (Map.Entry<Integer, Integer> a : map.entrySet()) {
            if (a.getValue() == 1) {
                op.add(a.getKey());
            }
        }

        return op;
    }
}
