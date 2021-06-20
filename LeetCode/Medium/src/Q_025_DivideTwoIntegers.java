public class Q_025_DivideTwoIntegers {
    public static void main(String[] args) {
//        System.out.println(divide(10, 3));
//        System.out.println(divide(7, -3));
//        System.out.println(divide(0, 1));
//        System.out.println(divide(1, 1));
//        System.out.println(divide(-2147483648, -1));
//        System.out.println(1 << 31);
        System.out.println(Math.round(6 / 4));
//        System.out.println(divide(2147483647, 2));
    }

    public static int divide(int dividend, int divisor) {

        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = (dividend < 0) == (divisor < 0);

        int negDividend = -Math.abs(dividend);
        int negDivisor = -Math.abs(divisor);
        int count = 0;

        while (negDividend < 0) {
            int binaryCount = 1;
            int binaryResult = negDivisor;
            if (binaryResult < negDividend) {
                break;
            }

            while (binaryResult >= negDividend - binaryResult) {
                binaryResult *= 2;
                binaryCount *= 2;
            }

            negDividend -= binaryResult;
            count += binaryCount;
        }
        return sign? count: -count;
    }
}
