import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] Arr = {1, 2, 3, 4, 5};
        int[] newArr = reverseArray(Arr);
        Arrays.stream(newArr).boxed().forEach(System.out::println);
    }

    private static int[] reverseArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end) {
            //swap a[start] <=> a[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }
}
