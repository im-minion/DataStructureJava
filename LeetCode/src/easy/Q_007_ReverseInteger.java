/*
7. Reverse Integer
Easy
Given a signed 32-bit integer x, return x with its digits reversed.
If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
*/
public class Q_007_ReverseInteger {
    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
        }
        x = Math.abs(x);
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        String s = sb.reverse().toString();
        try {
            return isNeg ? -Integer.parseInt(s) : Integer.parseInt(s);
        } catch (Exception e) {
            return 0;
        }
    }
}
