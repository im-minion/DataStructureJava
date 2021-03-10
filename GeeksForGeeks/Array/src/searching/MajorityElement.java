package searching;

/*
Majority Element
Difficulty Level : Medium
Write a function which takes an array and prints the majority element (if it exists),
 otherwise prints “No Majority Element”.
 A majority element in an array A[] of size n is an element that appears more than n/2 times
 (and hence there is at most one such element).

Examples :

Input : {3, 3, 4, 2, 4, 4, 2, 4, 4}
Output : 4
Explanation: The frequency of 4 is 5 which is greater
than the half of the size of the array size.

Input : {3, 3, 4, 2, 4, 4, 2, 4}
Output : No Majority Element
Explanation: There is no element whose frequency is
greater than the half of the size of the array size.
*/

import java.util.HashMap;

public class MajorityElement {
    public static void main(String[] args) {
        int[] a = new int[]{3, 3, 4, 2, 4, 4, 2, 4, 4};

        int op = findMajority(a);
        System.out.println(op);

        op = getMajor(a);
        System.out.println(op);
    }

    private static int getMajor(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                int currCount = hashMap.get(arr[i]) + 1;
                hashMap.put(arr[i], currCount);
                if (currCount > (arr.length / 2)) {
                    return arr[i];
                }
            } else {
                hashMap.put(arr[i], 1);
            }
        }
        return -1;
    }

    // gets the majority element
    private static int findMajority(int[] arr) {
        int major = arr[0];
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (count == 0) {
                major = arr[i];
            } else if (arr[i] == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }
}
