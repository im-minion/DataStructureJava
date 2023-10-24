package medium;

import java.util.LinkedList;
import java.util.Queue;

/*
Given an n x n grid containing only values 0 and 1, where 0 represents water and 1 represents land,
find a water cell such that its distance to the nearest land cell is maximized, and return the distance.
If no land or water exists in the grid, return -1.

The distance used in this problem is the Manhattan distance: the distance between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.*/
public class Q_1162_AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int res = -1;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) q.add(new int[]{i, j});
            }
        }

        if (q.isEmpty() || q.size() == n * n) return -1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            res++;
            while (size > 0) {
                int[] cell = q.poll();
                int x = cell[0];
                int y = cell[1];
                size--;
                for (int[] dir : dirs) {
                    int i = x + dir[0];
                    int j = y + dir[1];
                    if (i >= 0 && j >= 0 && i < n && j < n && grid[i][j] == 0) {
                        grid[i][j] = 1;
                        q.add(new int[]{i, j});
                    }
                }
            }
        }

        return res;
    }
}
