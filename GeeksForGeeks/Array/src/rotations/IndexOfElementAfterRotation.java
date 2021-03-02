package rotations;

/*
   URL :https://www.geeksforgeeks.org/find-element-given-index-number-rotations/
   An array consisting of N integers is given.
   There are several Right Circular Rotations of range[L..R] that we perform.
   After performing these rotations, we need to find element at a given index.
   Find element at given index after a number of rotations
   Input : arr[] : {1, 2, 3, 4, 5}
            ranges[] = { {0, 2}, {0, 3} }
            index : 1
    Output : 3
    Explanation : After first given rotation {0, 2}
                    arr[] = {3, 1, 2, 4, 5}
                  After second rotation {0, 3}
                    arr[] = {4, 3, 1, 2, 5}
    After all rotations we have element 3 at given index 1.

 * */
public class IndexOfElementAfterRotation {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[][] ranges = {{0, 2}, {0, 3}};
        int index = 1;
        System.out.println(getElement(arr, ranges, index));
    }

    private static int getElement(int[] arr, int[][] ranges, int index) {
        int rotations = ranges.length;
        for (int i = rotations - 1; i >= 0; i--) {
            int left = ranges[i][0];
            int right = ranges[i][1];
            if (left <= index && right >= index) { //if in bounds then only change
                if (index == left) { // if left (i.e. fromRotate no.) is the index, index will be changed to right
                    index = right;
                } else { // if not then subtract index
                    index--;
                }

            }
        }
        return arr[index];
    }
}
