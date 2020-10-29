import java.util.List;

public class ThirdMax {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 }; // { 4, 3, 2, 7, 8, 2, 3, 1 };
        int result = getThirdMax(arr);
        System.out.println(result);
    }

    private static int getThirdMax(int[] arr) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;

        for (Integer n : arr) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3))
                continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

}
