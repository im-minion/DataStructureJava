package misc;

import java.util.HashMap;
import java.util.Map;

public class SingleNo {
    public static void main(String[] args) {
        int[] data = new int[] { 4, 1, 2, 1, 2 };
        // only one number in input array occurs for one time, find that
        int number = findSingleNumber(data);
        System.out.println("Single Number " + number);
    }

    private static int findSingleNumber(int data[]) {
        if (data == null || data.length == 0)
            return -1;
        Map<Integer, Integer> holder = new HashMap<>();
        for (int number : data) {
            if (holder.containsKey(number)) {
                holder.put(number, holder.get(number) + 1);
            } else {
                holder.put(number, 1);
            }
        }
        for (int number : data) {
            if (holder.get(number) == 1) {
                return number;
            }
        }
        return -1;
    }
}