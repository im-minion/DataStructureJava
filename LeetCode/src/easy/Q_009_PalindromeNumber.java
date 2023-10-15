package easy;

public class Q_009_PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = String.valueOf(x);
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public boolean isPalindrome_Solution2(int x) {
        if (x < 0) return false;
        int orig = x;

        int rev = 0;
        while (x != 0) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }

        return rev == orig;
    }
}
