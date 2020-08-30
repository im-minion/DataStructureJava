import java.util.LinkedList;
import java.util.Queue;

public class DungeonGrid {
    Queue<Integer> rQueue = new LinkedList<>();
    Queue<Integer> cQueue = new LinkedList<>();
    int moveCount = 0;
    int nodesLeftInLayer = 1;
    int nodesInNextLayer = 0;

    boolean reachedEnd = false;

    int dr[] = { -1, 1, 0, 0 };
    int dc[] = { 0, 0, 1, -1 };
    String[][] dungeon = {

            { "S", null, null, "#", null, null, null },

            { null, "#", null, null, null, "#", null },

            { null, "#", null, null, null, "#", null },

            { null, null, "#", "#", null, null, null },

            { "#", null, "#", "E", null, "#", null }

    };
    int R = 5;
    int C = 7;
    boolean[][] visited = new boolean[R][C];

    int time = escapeTime(dungeon, dungeon.length, dungeon[0].length);;

    public static void main(String[] args) {
        DungeonGrid grid = new DungeonGrid();
        int time = grid.escapeTime(grid.dungeon, grid.R, grid.C);
        System.out.println(time);
    }

    private int escapeTime(String[][] dungeon, int R, int C) {
        rQueue.add(0);
        cQueue.add(0);
        visited[0][0] = true;
        while (!rQueue.isEmpty()) { // cQueue
            int r = rQueue.poll();
            int c = cQueue.poll();

            if (dungeon[r][c] == "E") {
                // we have reached end
                reachedEnd = true;
                break;
            }
            exploreNeighbors(r, c);
            nodesLeftInLayer--;
            if (nodesLeftInLayer == 0) {
                nodesLeftInLayer = nodesInNextLayer;
                nodesInNextLayer = 0;
                moveCount++;
            }
        }
        if (reachedEnd) {
            return moveCount;
        }
        return -1;
    }

    private void exploreNeighbors(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int rr = x + dr[i];
            int cc = y + dc[i];

            if (rr < 0 || cc < 0)
                continue;
            if (rr >= R || cc >= C)
                continue;

            if (visited[rr][cc])
                continue;
            if (dungeon[rr][cc] == "#")
                continue;
            rQueue.add(rr);
            cQueue.add(cc);
            visited[rr][cc] = true;
            nodesInNextLayer++;
        }
    }
}