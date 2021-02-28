import java.util.Arrays;

/*
 * Given an array of elements of length N, ranging from 0 to N – 1.
 * All elements may not be present in the array.
 * If the element is not present then there will be -1 present in the array.
 * Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
                  0   1  2  3  4  5  6   7  8  9
 * Input : arr ={-1, -1, 6, 1, 9, 3, 2, -1, 4, -1}
 * Output :     [-1, 1, 2, 3, 4, -1, 6, -1, -1, 9]
                   0  1  2  3  4   5   6   7  8  9  10  11 12  13 14  15  16 17  18  19
 * Input : arr = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 10, 9, 5, 13, 16, 2, 14, 17, 4}
 * Output : [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19]
 * */
public class RearrangeAOfItoI {
    public static void main(String[] args) {
        int[] arr = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};

//        fixArray(arr);

        fixArrayOptimal(arr);

        Arrays.stream(arr).boxed().forEach(System.out::print);
    }


    // O(n2) approach is just navigating from 0 to n two times and if i == a[j] just swap a[i] with a[j]
    private static void fixArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == arr[j]) {
                    // swap a[i] a[j]
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
        }
    }


    private static void fixArrayOptimal(int[] arr) {
        for (int i = 0; i < arr.length; ) {
            // if arr[i]>0 and arr[i] != i then something needs to be done else array is inline
            if (arr[i] >= 0 && arr[i] != i) {
                // swap arr[i] <=> arr[arr[i]]
                int ele = arr[arr[i]];
                arr[arr[i]] = arr[i];
                arr[i] = ele;
            } else {
                i++;
            }
        }
    }


}
