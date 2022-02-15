package medium;/*
371. Sum of Two Integers
Given two integers a and b, return the sum of the two integers without using the operators + and -.

Example 1:
Input: a = 1, b = 2
Output: 3

Example 2:
Input: a = 2, b = 3
Output: 5
*/

public class Q_371_SumOfTwoIntegers {
    public static void main(String[] args) {

    }

    public int getSum(int a, int b) {
        while (b != 0) {
            int c = a & b;
            a = a ^ b;

            b = c << 1;
        }

        return a;
    }
}
