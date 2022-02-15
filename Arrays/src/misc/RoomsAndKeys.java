package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RoomsAndKeys {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> room1 = new ArrayList<>();
        room1.add(1);
        room1.add(3);

        List<Integer> room2 = new ArrayList<>();
        room2.add(3);
        room2.add(0);
        room2.add(1);

        List<Integer> room3 = new ArrayList<>();
        room3.add(2);

        List<Integer> room4 = new ArrayList<>();
        room4.add(0);

        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        rooms.add(room4);
        boolean result = RoomsAndKeys.solve(rooms);
        System.out.println(result);
    }

    public static boolean solve(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0)
            return true;
        Stack<Integer> keys = new Stack<>();
        boolean[] visited = new boolean[rooms.size()];

        visited[0] = true;

        keys.addAll(rooms.get(0));
        while (!keys.isEmpty()) {
            int currentKey = keys.pop();
            List<Integer> newKeys = rooms.get(currentKey);

            for (Integer key : newKeys) {
                if (!visited[key]) {
                    visited[key] = true;
                    keys.addAll(rooms.get(key));
                }
            }
        }

        for (int i = 0; i < visited.length; i++) {
            System.out.println(i + " : " + visited[i]);
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }
}