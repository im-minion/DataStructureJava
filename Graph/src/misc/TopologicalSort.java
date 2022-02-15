package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * FIND TOPOLOGICAL ORDER
 */
public class TopologicalSort {
    public static void main(String[] args) {
        System.err.println("\n\nExample 1 ::");

        DirectedGraph graph = new DirectedGraph(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        /**
         *  0 ----> 1  
         *          |
         *  4 ->3<- 2
         *      |
         *      5 
         */
        TopologicalSort topologicalSort = new TopologicalSort();
        List<Integer> sortingOrderList = topologicalSort.getTopologyOrder(graph);
        sortingOrderList.forEach(x -> System.out.println(x));

        System.err.println("\n\nExample 2 ::");

        DirectedGraph graph2 = new DirectedGraph(6);
        graph2.addEdge(2, 3);
        graph2.addEdge(3, 1);
        graph2.addEdge(4, 0);
        graph2.addEdge(4, 1);
        graph2.addEdge(5, 2);
        graph2.addEdge(5, 0);
        topologicalSort = new TopologicalSort();
        sortingOrderList = topologicalSort.getTopologyOrder(graph2);
        sortingOrderList.forEach(x -> System.out.println(x));
    }

    private List<Integer> getTopologyOrder(DirectedGraph graph) {
        List<Integer> topologySortOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<Integer>();

        // Call the recursive helper function to store Topological Sort starting from
        // all vertices one by one
        for (int i = 0; i < graph.V; i++)
            if (!visited.contains(i))
                dfs(i, visited, stack, graph);

        // Print contents of stack
        while (stack.empty() == false) {
            topologySortOrder.add(stack.pop());
        }
        return topologySortOrder;
    }

    private void dfs(int node, Set<Integer> visited, Stack<Integer> stack, DirectedGraph graph) {

        // Mark the current node as visited.
        visited.add(node);
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = graph.adj.get(node).iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited.contains(i))
                dfs(i, visited, stack, graph);
        }

        // Push current vertex to stack which stores result
        stack.push(node);
    }

}

class DirectedGraph {
    // No. of vertices
    public int V;

    // Adjacency List as ArrayList of ArrayList's
    public ArrayList<ArrayList<Integer>> adj;

    // Constructor
    DirectedGraph(int v) {
        V = v;
        adj = new ArrayList<ArrayList<Integer>>(v);
        for (int i = 0; i < v; ++i)
            adj.add(new ArrayList<Integer>());
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }
}