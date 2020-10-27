public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int n1[] = { 1, 4, 8, 10, 20, 55, 66, 77 };
        int n2[] = { 0, 2, 3, 7, 9, 67, 78, 98, 108, 110 };
        int l1 = n1.length;
        int l2 = n2.length;
        int result[] = mergeArrays(n1, l1, n2, l2);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    private static int[] mergeArrays(int[] n1, int l1, int[] n2, int l2) {
        int[] result = new int[l1 + l2];
        int i = l1 - 1;
        int j = l2 - 1;
        int k = l1 + l2 - 1;
        while (i > -1 && j > -1) {
            result[k] = (n1[i] > n2[j]) ? n1[i--] : n2[j--];
            k--;
        }
        while (j > -1) {
            result[k] = n2[j--];
            k--;
        }

        return result;
    }
}
