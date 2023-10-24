package medium;

import java.util.LinkedList;
import java.util.Queue;

/*
* You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
* */
public class Q_994_RottingOranges {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;
        int[][] visited = grid;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int countFresh = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                if (visited[i][j] == 1) {
                    countFresh++;
                }
            }
        }
        if (countFresh == 0) {
            return 0;
        }
        if (q.isEmpty()) {
            return -1;
        }
        int min = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];

                for (int[] dir : dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i >= 0 && j >= 0 && i < m && j < n && visited[i][j] == 1) {
                        visited[i][j] = 2;
                        countFresh--;
                        q.add(new int[]{i, j});
                    }
                }
            }
            min++;
        }

        if (countFresh == 0) {
            return min;
        }
        return -1;
    }
}
