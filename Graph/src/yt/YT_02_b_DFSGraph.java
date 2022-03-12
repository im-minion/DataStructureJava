package yt;

import java.util.ArrayList;

/**
 * @author vaibhav.miniyar
 */
public class YT_02_b_DFSGraph {
    public static void main(String[] args) {

    }

    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> op = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for (int i = 0 ; i < V;  i ++) {
            vis[i] = false;
        }
        helper(adj, 0, vis, op);
        return op;
    }

    private void helper(ArrayList<ArrayList<Integer>> adj, int start, boolean[] vis, ArrayList<Integer> op) {
        op.add(start);
        vis[start] = true;

        for (int neighbor : adj.get(start)) {
            if (!vis[neighbor]) {
                helper(adj, neighbor, vis, op);
            }
        }

    }
}
