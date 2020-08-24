public class FibonacciSeries {
    public static void main(String[] args) {
        int i = 6;
        System.out.println("Number " + i);
        System.out.println(getFibonacciForNumber(i));
    }

    private static int getFibonacciForNumber(int i) {
        if (i <= 1) {
            return i;
        }
        int n = getFibonacciForNumber(i - 1) + getFibonacciForNumber(i - 2);
        return n;

    }
}