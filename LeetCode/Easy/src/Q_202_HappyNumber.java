import java.util.HashSet;
import java.util.Set;

public class Q_202_HappyNumber {
    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }

    // little faster
    public static boolean isHappy(int n) {
        if (n < 0) return false;
        if (n == 1) return true;
        int counter = 0;
        int currSum = Integer.MAX_VALUE;
        while (n <= Integer.MAX_VALUE - 1 && counter <= 100) {
            if (currSum == 1) {
                return true;
            } else {
                String s = String.valueOf(n);
                int x = s.length() - 1;
                currSum = 0;
                while (x >= 0) {
                    int digit = (s.charAt(x) - '0');
                    currSum = currSum + (digit * digit);
                    x--;
                }
                n = currSum;
            }
            counter++;
        }

        return false;
    }

    // fastest
    public static boolean isHappy2(int n) {
        if (n < 0) return false;
        Set<Integer> records = new HashSet<>();
        while (n != 1 && !records.contains(n)) {
            records.add(n);
            n = getNewN(n);
        }
        return n == 1;
    }

    private static int getNewN(int n) {
        int res = 0;
        while (n > 0) {
            int tmp = n % 10;
            res += tmp * tmp;
            n /= 10;
        }
        return res;
    }
}
