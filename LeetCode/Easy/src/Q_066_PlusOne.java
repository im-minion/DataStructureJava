public class Q_066_PlusOne {
    public static void main(String[] args) {
        String x = "";
        int y = 90;
        StringBuilder sb = new StringBuilder();
        sb.append(y);
        System.out.println(sb.toString());
    }

    public int[] plusOne(int[] digits) {
        int n = digits.length - 1;
        if (digits[n] < 9) {
            digits[n] = digits[n] + 1;
            return digits;
        } else {
            int i = n;
            while (i >= 0 && digits[i] == 9) {
                digits[i] = 0;
                i--;
            }

            if (i >= 0) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                int[] newArr = new int[n + 2];
                newArr[0] = 1;
                int j;
                int x = 0;
                for (j = 1; j < newArr.length; j++) {
                    newArr[j] = digits[x++];
                }
                return newArr;
            }
        }

    }
}
