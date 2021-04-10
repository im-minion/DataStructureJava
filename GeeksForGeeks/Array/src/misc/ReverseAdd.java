package misc;

public class ReverseAdd {
    public static void main(String[] args) {
        int a = 265;
        boolean op = isReverseAddPalindrome(a);
        System.out.println(op);
    }

    private static boolean isReverseAddPalindrome(long a) {
        long revOfA = 0;
        int itr = 0;
        while (itr < 10000 && a <= 4294967295L) {
            revOfA = getReverseOf(a);
            a = a + revOfA;
            if (isPalindrome(a)) {
                return true;
            }
            itr++;
        }
        return false;
    }

    private static boolean isPalindrome(long a) {
        return getReverseOf(a) == a;
    }

    private static long getReverseOf(long a) {
        long rev = 0;
        while (a != 0) {
            long t = a % 10;
            rev = rev * 10 + t;
            a = a / 10;
        }
        return rev;
    }
}
