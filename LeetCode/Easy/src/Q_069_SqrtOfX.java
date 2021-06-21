
//TODO: Understand UTS
public class Q_069_SqrtOfX {
    public static void main(String[] args) {
        System.out.println(mySqrt(16));
    }

    public static int mySqrt(int x) {
        if (x <= 1) return x;

        int l = 0;
        int h = x;

        while (true) {
            int mid = l + ((h - l) / 2);
            int c = x / mid;
            if (c < mid) {
                h = mid - 1;
            } else {
                if ((mid + 1) > x / (mid + 1)) {
                    return mid;
                } else {
                    l = mid + 1;
                }
            }
        }
    }
}
