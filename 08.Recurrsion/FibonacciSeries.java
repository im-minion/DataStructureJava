/**
 * 
 * for FibonacciSeries the constrain
 * 
 * the Nth element in fibonacci series will be
 * 
 * 1 if N<=1
 * 
 * 
 */

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println("Number at index" + " 6 " + " is :" + getFibonacciForNumber(6));

        System.out.println("Number at index" + " 5 " + " is :" + getFibonacciForNumber(5));

        printFibonacciSeriesTill(10);
    }

    private static void printFibonacciSeriesTill(int n) {
        System.out.println("Printing all element in Fibonacci series till index : " + n);
        for (int i = 0; i < n; i++) {
            System.out.print(getFibonacciForNumber(i) + " ");
        }
    }

    private static int getFibonacciForNumber(int i) {
        if (i <= 1) {
            return 1;
        }
        int n = getFibonacciForNumber(i - 1) + getFibonacciForNumber(i - 2);
        return n;

    }
}