import java.util.Arrays;

public class KadanesAlgoMaxSubArray {
    /*
    Input:
    N = 5
    arr[] = {1,2,3,-2,5}
    Output:
    9
    Explanation:
    Max subarray sum is 9 of elements (1, 2, 3, -2, 5)

    Input:
    N = 4
    arr[] = {-1,-2,-3,-4}
    Output:
    -1
    Explanation:
    Max subarray sum is -1 of element (-1)

    LOOK AT EACH INDEX FIND WHAT IS MAX AT THAT INDEX.
    */
    public static void main(String[] args) {
        int[] Arr = {1, 2, 3, 4, -10};
        int result = maxSubArray(Arr);
        System.out.println(result);
    }

    private static int maxSubArray(int[] arr) {
        int maxSoFar = Integer.MIN_VALUE;

        int currMax = 0;

        int[] kadanesArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            currMax = currMax + arr[i];
            if (currMax < arr[i]) {
                currMax = arr[i];
            }
            kadanesArray[i] = currMax;
            maxSoFar = Math.max(currMax, maxSoFar);
        }
        Arrays.stream(kadanesArray).forEach(el -> System.out.print(el + "\t"));
        System.out.println("\n");
        return maxSoFar;
    }
}
