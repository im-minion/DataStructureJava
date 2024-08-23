package backtracking;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class YT_04a_RatMaze {
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        Set<String> op = new TreeSet<>();

        int rN = mat.length;
        int cN = mat[0].length;
        if (mat[rN - 1][cN - 1] == 0 || mat[0][0] == 0) {
            return new ArrayList<>();
        }

        solve(mat, cN, rN, 0, 0, op, new StringBuilder(" "));
        return new ArrayList<>(op);
    }

    private void solve(int[][] mat, int cN, int rN, int r, int c, Set<String> op, StringBuilder currStr) {
        if (r == rN - 1 && c == cN - 1) {
            op.add(currStr.toString());
            return;
        }
        int[] rowChange = {-1, 1, 0, 0};
        int[] colChange = {0, 0, -1, 1};
        char[] dir = {'U', 'D', 'L', 'R'};

        for (int i = 0; i < 4; i++) {
            int newR = r + rowChange[i];
            int newC = c + colChange[i];

            if (newR < rN && newR >= 0 && newC < cN && newC >= 0 && mat[newR][newC] != 0) {
                currStr.append(dir[i]);
                mat[r][c] = 0;

                solve(mat, cN, rN, newR, newC, op, currStr);

                mat[r][c] = 1;
                currStr.deleteCharAt(currStr.length() - 1);
            }
        }
    }
}
