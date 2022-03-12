package yt;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author vaibhav.miniyar
 */
public class YT_02_b_BFSGraph {
    public static void main(String[] args) {
        // make visited tru e when you add an element inside a queue
    }

    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> op = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];
        for (int i = 0 ; i < V ; i++) {
             vis[i] = false;
        }
        queue.add(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int t = queue.poll();
           op.add(t);
           for (int i = 0 ; i < adj.get(t).size() ; i ++ ) {
               if (!vis[adj.get(t).get(i)]) {
                   queue.add(adj.get(t).get(i));
                   vis[adj.get(t).get(i)] = true;
               }
           }
        }

        return op;
    }
}
