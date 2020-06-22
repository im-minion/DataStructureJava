public class Max1s {
    public static void main(String[] args) {
        int ar[] = { 1, 1, 0, 1, 1, 1 };
        int count = getMax1s(ar);
        System.out.println(count);
    }

    private static int getMax1s(int[] ar) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < ar.length; i++) {
            count = ar[i] == 0 ? 0 : count + 1;
            max = Math.max(max, count);
        }
        return max;
    }
}