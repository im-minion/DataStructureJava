public class PlusOne {
    public static void main(String[] args) {
        int array[] = { 9, 9, 9, 9, 9 };

        int result[] = plusOne(array);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + "\t");
        }
    }

    static int[] plusOne(int a[]) {
        int n = a.length;
        for (int i = n - 1; i >= 0; i--) {
            if (a[i] < 9) {
                a[i]++;
                return a;
            }
            a[i] = 0;
        }
        int newNumber[] = new int[n + 1];
        newNumber[0] = 1;
        return newNumber;
    }
}