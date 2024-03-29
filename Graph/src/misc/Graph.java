package misc;
/**
 * DFS :: Time Complexity O(V+E)
 * 
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Graph {

    public Map<Integer, GraphNode> nodeLookup;

    Graph() {
        this.nodeLookup = new HashMap<>();
    }

    public void addEdge(int from, int to) {
        GraphNode fromNode = nodeLookup.get(from);
        GraphNode toNode = nodeLookup.get(to);
        fromNode.adjacentNodes.add(toNode);
    }

    public GraphNode getNode(int val) {
        if (!this.nodeLookup.containsKey(val)) {
            throw new IllegalStateException("No misc.GraphNode Found!");
        }
        return this.nodeLookup.get(val);
    }

    public boolean hasPathBFS(int source, int destination) {
        GraphNode sourceNode = getNode(source);
        GraphNode destinationNode = getNode(destination);
        Set<Integer> visited = new HashSet<>();
        List<Integer> prev = new ArrayList<>();
        Queue<GraphNode> queue = new LinkedList<>();

        queue.add(sourceNode);

        while (!queue.isEmpty()) {
            GraphNode currNode = queue.poll();
            // visited contains the contains the currentNide means we have already added all
            // its adj to the queue
            if (visited.contains(currNode.id)) {
                continue;
            }
            visited.add(currNode.id);
            prev.add(currNode.id);
            if (currNode == destinationNode) {
                printPath(prev);
                return true;
            }
            for (GraphNode n : currNode.adjacentNodes) {
                queue.add(n);
            }

        }
        return false;
    }

    private void printPath(List<Integer> prev) {
        prev.stream().forEach(n -> System.out.print(n + " ->"));
    }

    private boolean hasPathDFS(int source, int destination) {

        return hasPathDFS(getNode(source), getNode(destination), new HashSet<>());
    }

    private boolean hasPathDFS(GraphNode source, GraphNode destination, Set<Integer> visited) {
        if (visited.contains(source.id)) {
            return true;
        }
        visited.add(source.id);

        if (source == destination) {
            return true;
        }

        for (GraphNode adj : source.adjacentNodes) {
            return hasPathDFS(adj, destination, visited);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Creating a graph:");
        Graph graph = new Graph();
        System.out.println("Enter the number of nodes you wish to add to graph");

        try (Scanner scan = new Scanner(System.in)) {
            int num = scan.nextInt();
            int i = 0;
            while (i < num) {

                System.out.println("Enter the node id:");
                int nodeId = scan.nextInt();
                graph.nodeLookup.put(nodeId, new GraphNode(nodeId));
                i++;
            }
            System.out.println("Add edges :");

            System.out.println("Enter the number of edges you want to add: ");
            int numOfEdges = scan.nextInt();

            int k = 0;

            while (k < numOfEdges) {

                System.out.println("Add edge from : ");
                int from = scan.nextInt();
                System.out.println("Add edge to : ");
                int to = scan.nextInt();
                graph.addEdge(from, to);
                k++;
            }
            System.out.println("misc.Graph created.");

            System.out.println("Doing Depth first search on graph");
            System.out.println("Enter the source node:");
            int source = scan.nextInt();
            System.out.println("Enter the destination node: ");
            int destination = scan.nextInt();
            System.out.println("has path : " + graph.hasPathDFS(source, destination));

            System.out.println("Doing Breadth first search on graph:");
            System.out.println("Enter the source node:");
            source = scan.nextInt();
            System.out.println("Enter the destination node: ");
            destination = scan.nextInt();
            System.out.println("has path : " + graph.hasPathBFS(source, destination));
        }
    }

}

class GraphNode {

    int id;
    LinkedList<GraphNode> adjacentNodes = new LinkedList<>();

    public GraphNode(int id) {

        this.id = id;
    }
}