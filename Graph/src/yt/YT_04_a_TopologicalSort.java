package yt;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author vaibhav.miniyar
 */
public class YT_04_a_TopologicalSort {
    //Function to return list containing vertices in Topological order.
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        // add your code here
        int[] op = new int[V];
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i] ) {
                dfs(adj, V, 0, vis, stack);
            }
        }

        int i = 0;
        while (!stack.isEmpty()) {
            op[i++] = stack.pop();
        }
        return op;
    }

    static void dfs(ArrayList<ArrayList<Integer>> adj, int V, int start, boolean[] vis, Stack<Integer> stack) {
        vis[start] = true;

        for (int node : adj.get(start)) {
            if (!vis[node]) {
                dfs(adj, V, node, vis, stack);
            }
        }
        stack.push(start);
    }

}
