package yt;

import java.util.ArrayList;

/**
 * @author vaibhav.miniyar
 */
public class YT_03_a_DetectCycleInUndirected {
    public static void main(String[] args) {

    }

    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfsDetectCycle(adj, V, vis, i, -1)) {
                return true;
            }
        }
        return false;
    }

    boolean dfsDetectCycle(ArrayList<ArrayList<Integer>> adj, int N, boolean vis[], int start, int parent) {
        vis[start] = true;
        for (int node : adj.get(start)) {
            if (!vis[node]) {
                if (dfsDetectCycle(adj, N, vis, node, start)) {
                    return true;
                }
            }else if (node != parent) {
                return true;
            }
        }
        return false;
    }

}
