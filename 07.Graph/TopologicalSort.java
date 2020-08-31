import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * FIND TOPOLOGICAL ORDER
 */
public class TopologicalSort {
    public static void main(String[] args) {
        System.err.println("\n\nExample 1 ::");

        DirectedGraph graph = new DirectedGraph(6);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(5, 4);
        /**
         *  1 -> 2  
         *      |
         *  4 <- 3
         *  |
         *  6 -> 5
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
        /**
         *  1 -> 2  
         *      |
         *  4 <- 3
         *  |
         *  6 -> 5
         *
         */
        topologicalSort = new TopologicalSort();
        sortingOrderList = topologicalSort.getTopologyOrder(graph2);
        sortingOrderList.forEach(x -> System.out.println(x));


    }
    

    private List<Integer> getTopologyOrder(DirectedGraph graph) {
        List<Integer> topologySortOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0 ; i < graph.V; i++) {
            if (!visited.contains(i)) {
                dfs(i, visited, graph, topologySortOrder);
            }
        }
        return topologySortOrder;
    }

    private void dfs(int node, Set<Integer> visited, DirectedGraph graph, List<Integer> topologySortOrder) {
        if (!visited.contains(node)) {
            visited.add(node);
            topologySortOrder.add(node);
        } else {
            for (int n : graph.adj.get(node)) {
                dfs(n, visited, graph, topologySortOrder);
            }
        }
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