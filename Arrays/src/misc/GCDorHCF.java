package misc;

public class GCDorHCF {
    public static void main(String[] args) {
        int result = gcd(6, 9);
        System.out.println(result);
    }

    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
    
//      public static int gcd(int a, int b) {
//         if (a == 0)
//             return b;
//         return gcd(b % a, b);
//     }
}
