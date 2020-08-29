import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Graph {

    private Map<Integer, Node> nodeLookup = new HashMap<>();

    private void addEdge(int from, int to) {
        Node fromNode = nodeLookup.get(from);
        Node toNode = nodeLookup.get(to);
        fromNode.adjacentNodes.add(toNode);
    }

    private Node getNode(int val) {
        if (!this.nodeLookup.containsKey(val)) {
            throw new IllegalStateException("No Node Found!");
        }
        return this.nodeLookup.get(val);
    }

    private boolean hasPathBFS(int source, int destination) {
        Node sourceNode = getNode(source);
        Node destinationNode = getNode(destination);
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(sourceNode);

        while (!queue.isEmpty()) {
            Node currNode = queue.poll();
            // visited contains the contains the currentNide means we have already added all
            // its adj to the queue
            if (visited.contains(currNode.id)) {
                continue;
            }
            visited.add(currNode.id);
            if (currNode == destinationNode) {
                return true;
            }
            for (Node n : currNode.adjacentNodes) {
                queue.add(n);
            }

        }
        return false;
    }

    private boolean hasPathDFS(int source, int destination) {

        return hasPathDFS(getNode(source), getNode(destination), new HashSet<>());
    }

    private boolean hasPathDFS(Node source, Node destination, Set<Integer> visited) {
        if (visited.contains(source.id)) {
            return true;
        }
        visited.add(source.id);

        if (source == destination) {
            return true;
        }

        for (Node adj : source.adjacentNodes) {
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
                graph.nodeLookup.put(nodeId, new Node(nodeId));
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
            System.out.println("Graph created.");

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

class Node {

    int id;
    LinkedList<Node> adjacentNodes = new LinkedList<>();

    public Node(int id) {

        this.id = id;
    }
}