package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {
        System.out.println("\n\nExample 1 ::");

        DirectedGraph graph = new DirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);

        graph.addEdge(1, 0);
        graph.addEdge(1, 2);

        graph.addEdge(2, 1);
        graph.addEdge(2, 3);

        graph.addEdge(3, 0);
        graph.addEdge(3, 2);

        /*
         *  0 <----> 1
         *  |        |
         *  3 <----> 2
         */

        System.out.println(solveIsBipartite(graph.adj, graph.V));
    }

    static class Pair {
        int vertex;
        int color;

        public Pair(int vertex, int color) {
            this.vertex = vertex;
            this.color = color;
        }
    }

    private static boolean solveIsBipartite(ArrayList<ArrayList<Integer>> adj, int V) {
        int[] col = new int[V];
        Arrays.fill(col, -1);
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (col[i] != -1) {
                q.add(new Pair(i, 0));
                col[i] = 1;

                while (!q.isEmpty()) {
                    Pair curr = q.poll();
                    int currV = curr.vertex;
                    int currC = curr.color;
                    for (int ngh : adj.get(currV)) {
                        if (col[ngh] == currV) {
                            return false;
                        }
                        if (col[ngh] == -1) {
                            col[ngh] = currC == 0 ? 1 : 0;
                            q.add(new Pair(ngh, col[ngh]));
                        }
                    }
                }
            }
        }
        return true;
    }
}
