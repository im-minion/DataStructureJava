package orderstatistics;

public class SecondSmallest {
    public static void main(String[] args) {
        int arr[] = {12, 13, 1, 10, 34, 2, -12, -6, -6, -6};
        int op = get2Smallest(arr);
        System.out.println(op);
    }

    private static int get2Smallest(int[] arr) {
        if (arr.length == 0) return -1;
        if (arr.length == 1) return arr[0];
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= second) {
                if (arr[i] <= first) {
                    second = first;
                    first = arr[i];
                } else {
                    second = arr[i];
                }
            }
        }
        return second;
    }
}
