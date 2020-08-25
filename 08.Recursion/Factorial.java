public class Factorial {
    public static void main(String[] args) {
        System.out.println(getFactorialOf(5));
        System.out.println(getFactorialOf(0));
        System.out.println(getFactorialOf(6));
        System.out.println(getFactorialOf(3));
    }

    private static int getFactorialOf(int i) {
        if (i == 0) {
            return 1;
        }
        return i * getFactorialOf(i - 1);
    }
}