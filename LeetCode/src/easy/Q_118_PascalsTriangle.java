/*
* Pascal’s triangle is a triangular array of the binomial coefficients.
* Write a function that takes an integer value n as input and prints first n lines of the Pascal’s triangle.
* Following are the first 6 rows of Pascal’s Triangle.
    1
    1 1
    1 2 1
    1 3 3 1
    1 4 6 4 1
    1 5 10 10 5 1
*
* */

import java.util.ArrayList;
import java.util.List;

public class Q_118_PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> op = printPascaleTriangle(6);
    }

    private static List<List<Integer>> printPascaleTriangle(int n) {
        List<List<Integer>> op = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    l.add(1);
                } else {
                    l.add(op.get(i - 1).get(j - 1) + op.get(i - 1).get(j));
                }
            }
            System.out.println(l);
            op.add(l);
        }
        return op;
    }
}
