package misc;

/*
 * Implement pow(x, n) % d.
 * In other words, given x, n and d,
 * */
public class Power {
    public static void main(String[] args) {
        int r= pow(2,3, 3);
        System.out.println(r);
    }

    public static int pow(int x, int n, int d) {
        if (x == 0)
            return 0;
        if (n == 0)
            return 1 % d;
        java.math.BigInteger bi = java.math.BigInteger.valueOf(x);
        return bi.modPow(java.math.BigInteger.valueOf(n), java.math.BigInteger.valueOf(d)).intValue();
    }
}
