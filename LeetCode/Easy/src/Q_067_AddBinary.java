public class Q_067_AddBinary {
    public static void main(String[] args) {

    }

    public String addBinary(String a, String b) {
        StringBuilder op = new StringBuilder();

        int aP = a.length() - 1;
        int bP = b.length() - 1;
        int c = 0;

        while (aP >= 0 && bP >= 0) {
            int currA = a.charAt(aP--) - '0';
            int currB = b.charAt(bP--) - '0';
            int sum = currA + currB + c;
            if (sum == 0 || sum == 1) {
                op.append(sum);
                c = 0;
            } else if (sum == 2) {
                op.append("0");
                c = 1;
            } else if (sum == 3) { // 1 + 1 + 1
                op.append("1");
                c = 1;
            }
        }

        while (aP >= 0) {
            int currA = a.charAt(aP--) - '0';
            int sum = currA + c;
            if (sum > 1) { // 1 + 1
                op.append("0");
                c = 1;
                continue;
            } else {
                op.append(sum);
                c = 0;
            }
        }

        while (bP >= 0) {
            int currB = b.charAt(bP--) - '0';
            int sum = currB + c;
            if (sum > 1) { // 1+ 1
                op.append("0");
                c = 1;
                continue;
            } else {
                op.append(sum);
                c = 0;
            }
        }

        if (c == 1) {
            op.append(c);
        }

        return op.reverse().toString();
    }
}
