package gfg.searching;

/*
Leaders in an array
Difficulty Level : Easy

Write a program to print all the LEADERS in the array.

An element is leader if it is greater than all the elements to its right side. And the rightmost element is always a leader.

For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.
Let the input array be arr[] and size of the array be size.
*/

import java.util.ArrayList;
import java.util.List;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] arr = {1, 5, 7, 3, 1, 2};
        List<Integer> op = getLeaders(arr);
        System.out.println(op);
    }

    private static List<Integer> getLeaders(int[] arr) {
        List<Integer> op = new ArrayList<>();
        int j = arr.length - 1;
        int currLeaderIndex = j;
        op.add(arr[currLeaderIndex]);
        while (j >= 0) {
            if (arr[j] > arr[currLeaderIndex]) {
                op.add(arr[j]);
                currLeaderIndex = j;
            }
            j--;
        }
        return op;
    }
}
