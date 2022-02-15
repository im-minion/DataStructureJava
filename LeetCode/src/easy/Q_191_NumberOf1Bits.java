public class Q_191_NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }

    public static int hammingWeight(int n) {
        int mask = 1;
        int c = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                c++;
            }
            mask = mask << 1;
        }
        return c;
    }
}
