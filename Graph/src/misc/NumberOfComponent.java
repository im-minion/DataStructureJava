package misc; /**
 *  1 - 2  
 *      |
 *  4 - 3
 *  |
 *  6   5
 * 
 * 1st component is => 1-2-3-4-6 
 * 2nd component is => 5 
*/


import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumberOfComponent {
    static int getComponentsCount(Graph g) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();

        for (Map.Entry<Integer, GraphNode> e : g.nodeLookup.entrySet()) {
            if (!visited.contains(e.getKey())) {
                count++;
                dfs(g, e.getValue(), visited);
            }
        }

        return count;
    }

    private static void dfs(Graph g, GraphNode currNode, Set<Integer> visited) {
        if (visited.contains(currNode.id)) {
            return;
        }
        visited.add(currNode.id);
        for (GraphNode adj : currNode.adjacentNodes) {
            dfs(g, adj, visited);
        }
        return;
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.nodeLookup.put(1, new GraphNode(1));
        graph.nodeLookup.put(2, new GraphNode(2));
        graph.nodeLookup.put(3, new GraphNode(3));
        graph.nodeLookup.put(4, new GraphNode(4));
        graph.nodeLookup.put(5, new GraphNode(5));
        graph.nodeLookup.put(6, new GraphNode(6));

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);

        System.out.println(getComponentsCount(graph));
    }
}