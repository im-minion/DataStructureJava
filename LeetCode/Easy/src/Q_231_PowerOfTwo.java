public class Q_231_PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 1) return true;
        if (n % 2 != 0) return false;
        int c = 0;
        for (int i = 0; i < n; i++) {
            int val = (int) Math.pow(2, i);
            if (val == n) {
                return true;
            } else if (val > n) {
                return false;
            }
        }
        return false;
        //other one liner solution
//        return n > 0 && (n & (n - 1)) == 0;
    }
}
