package misc;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Connected components
 */
public class ConnectedComponents_FindGroups {
    public static void main(String[] args) {
        int n = 7;
        List<int[]> friendships = Arrays.asList(
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{4, 5},
                new int[]{6, 7}
        );

        List<List<Integer>> components = calculateGroups(n, friendships);
        int numExistingGroups = components.size();
        Set<Integer> allStudents = components.stream().flatMap(Collection::stream).collect(Collectors.toSet());
        int noOfNotConnectedStds = n - allStudents.size();

        int numNewGroups = (numExistingGroups - 1) + noOfNotConnectedStds * numExistingGroups +
                (noOfNotConnectedStds * (noOfNotConnectedStds - 1)) / 2;
        System.out.println("Existing Friend Groups: " + numExistingGroups);
        System.out.println("New Friend Groups that can be formed: " + numNewGroups);

    }

    private static List<List<Integer>> calculateGroups(int n, List<int[]> friendships) {
        // Build the graph as an adjacency list
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] pair : friendships) {
            int u = pair[0];
            int v = pair[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // BSF to find the connected components
        Set<Integer> visited = new HashSet<>();
        List<List<Integer>> components = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (!visited.contains(i)) {
                List<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();

                queue.add(i);
                visited.add(i);

                while (!queue.isEmpty()) {
                    Integer curr = queue.poll();
                    component.add(curr);
                    for (int ngh : graph.get(curr)) {
                        if (!visited.contains(ngh)) {
                            queue.add(ngh);
                            visited.add(ngh);
                        }
                    }
                }
                components.add(component);
            }
        }

        return components;

    }
}
