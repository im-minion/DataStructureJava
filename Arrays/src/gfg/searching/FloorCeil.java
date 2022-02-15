package gfg.searching;

/*
Ceiling in a sorted array
Difficulty Level : Easy

Given a sorted array and a value x,
the ceiling of x is the smallest element in array greater than or equal to x,
and the floor is the greatest element smaller than or equal to x.
Assume than the array is sorted in non-decreasing order. Write efficient functions to find floor and ceiling of x.

Examples :

For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8
For x = 20:   floor  = 19,  ceil doesn't exist in array
In below methods, we have implemented only ceiling search functions. Floor search can be implemented in the same way.
*/
public class FloorCeil {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        int key = 8;
        int[] op = getCeilFloor(arr, key);
        System.out.println("Floor :: " + op[0]);
        System.out.println("Ceil :: " + op[1]);

        int op1 = getCeilBSearch(arr, key);
        System.out.println("Ceil With Binary Search:: " + arr[op1]);

    }

    private static int getCeilBSearch(int[] arr, int key) {
        return bSearch(arr, 0, arr.length - 1, key);
    }

    private static int bSearch(int[] arr, int l, int h, int key) {
        int mid;
        if (key <= arr[l]) {
            return l;
        }
        if (key > arr[h]) {
            return -1;
        }
        mid = (l + h) / 2;

        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            if (mid + 1 <= h && key <= arr[mid + 1]) {
                return mid + 1;
            } else {
                return bSearch(arr, mid + 1, h, key);
            }
        } else {
            if (mid - 1 >= l && key > arr[mid - 1])
                return mid;
            else
                return bSearch(arr, l, mid - 1, key);
        }
    }

    private static int[] getCeilFloor(int[] arr, int key) {
        int[] op = new int[2];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > key) {
                i++;
            } else if (arr[i] < key) {
                if (i == 0) op[0] = -1;
                else op[0] = arr[i];
                if (i == arr.length - 1) op[1] = -1;
                else op[1] = arr[i + 1];
            } else {
                op[0] = arr[i];
                op[1] = arr[i];
                break;
            }
        }
        return op;
    }
}
