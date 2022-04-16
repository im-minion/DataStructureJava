package yt;

import java.util.ArrayList;

/**
 * @author vaibhav.miniyar
 */
public class YT_03_b_DetectCycleInDirectedGraph {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        boolean[] ancestors = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i] && dfsDetectCycle(adj, V, vis, i, ancestors)) {
                return true;
            }
        }
        return false;
    }

    public boolean dfsDetectCycle(ArrayList<ArrayList<Integer>> adj, int V, boolean[] vis, int start, boolean[] ancestors) {
        vis[start] = true;
        ancestors[start] = true;
        for (int node : adj.get(start)) {
            if (!vis[node]) {
                if (dfsDetectCycle(adj, V, vis, node, ancestors)) {
                    return true;
                }
            } else {
                if (ancestors[node]) {
                    return true;
                }
            }
        }
        ancestors[start] = false;
        return false;
    }
}
