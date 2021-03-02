package rotations;

public class MissingNumber {
    /*
    * Input: arr[] = {1, 2, 4, 6, 3, 7, 8}
    Output: 5
    Explanation: The missing number from 1 to 8 is 5

    Input: arr[] = {1, 2, 3, 5}
    Output: 4
    Explanation: The missing number from 1 to 5 is 4
    * */
    public static void main(String[] args) {
        int A[] = {1, 2, 4, 6, 3, 7, 8};
        System.out.println(MissingNumber(A, 8));
    }

    public static int MissingNumber(int array[], int n) {
        // Your Code Here
        int n_elements_sum = n * (n + 1) / 2;
        int sum = 0;

        for (int i = 0; i < n - 1; i++)
            sum += array[i];

        return n_elements_sum - sum;
    }
}
