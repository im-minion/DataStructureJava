package searching;

/*
Find position of an element in a sorted array of infinite numbers
Difficulty Level : Medium

Suppose you have a sorted array of infinite numbers, how would you search an element in the array?

Source: Amazon Interview Experience.
Since array is sorted, the first thing clicks into mind is binary search,
but the problem here is that we don’t know size of array.
If the array is infinite, that means we don’t have proper bounds to apply binary search.
So in order to find position of key, first we find bounds and then apply binary search algorithm.

Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,
->if it is greater than high index element then copy high index in low index and double the high index.
->if it is smaller, then apply binary search on high and low indices found.
*/
public class SearchInInfiniteArray {
    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int ans = searchForKey(arr, 170);

        if (ans == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + ans);
    }

    private static int searchForKey(int[] arr, int key) {
        int l = 0;
        int h = 1;
        int val = arr[0];
        while (val < key) {
            l = h;
            //inc h
            h = Math.min(2 * h, arr.length - 1);
            val = arr[h];
        }
        return bSearch(arr, l, h, key);
    }

    private static int bSearch(int[] arr, int l, int h, int key) {
        while (l <= h) {
            int mid = (l + h) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] > key) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
