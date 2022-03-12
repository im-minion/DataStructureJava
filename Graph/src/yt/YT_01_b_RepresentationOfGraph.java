package yt;

/**
 * @author vaibhav.miniyar
 */
public class YT_01_b_RepresentationOfGraph {
    public static void main(String[] args) {
        // 01 -> Adjacency Matrix
            // matrix of VxV
            // weighted means - adjacency max times!!
            // complexties->
            // Find edge -> O(1)
            // knwoing the neighbours -> O(V)
            // total space O(V2)
            // construct complexity O(V2)

        // 02 -> Adjancency List
            // ADVANTAGE -> rows are V, but every row will have only their neighbour
            // Saves the sapce!!
            // representation ->
            // Map<Integer, List<Integer>> graph or ->
            // List<List<Integer>> graph (here limitation is, if in a graph, a node value is 100 then its costly to store the element at 100th index)
            // List<Integer> graph[v]
            // complexity
            // Find Edge -> O(neighbour)
            // Space -> O(V+E)
            // Construct -> O(V+E)


    }
}
