import java.util.Arrays;

public class Q_006_ZigZagConversion {

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        String[] arr = new String[numRows];
        Arrays.fill(arr, "");
        StringBuilder op = new StringBuilder();
        boolean isDown = true;
        int n = s.length();
        int arrIndex = 0;
        for (int i = 0; i < n; i++) {
            String a = String.valueOf(s.charAt(i));
            if (isDown) {
                arr[arrIndex] += a;
                arrIndex++;
                if (arrIndex == numRows) {
                    isDown = false;
                    arrIndex -= 2;
                }
            } else {
                arr[arrIndex] += a;
                arrIndex--;
                if (arrIndex == -1) {
                    isDown = true;
                    arrIndex += 2;
                }
            }
        }

        for (String a : arr) {
            op.append(a);
        }

        return op.toString();
    }
}
