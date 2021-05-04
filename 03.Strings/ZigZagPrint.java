/*
Input:
str = "ABCDEFGH"
n = 2
Output: "ACEGBDFH"
Explanation:
Let us write input string in
Zig-Zag fashion in 2 rows.
A   C   E   G
B   D   F   H
Now concatenate the two rows and ignore
spaces in every row. We get "ACEGBDFH"



Input:
nrtysfrzrmzlygfveulqfp
19

Its Correct output is:
nrtysfrzrmzlygfvpefuql

And Your Code's output is:
nqrftpysfrzrmzlygfveul



GSGSEKFREKEOE

*/

// VERIFIED
public class ZigZagPrint {
    public static void main(String[] args) {
        System.out.println(convert("GEEKSFORGEEKS", 3
        ));
    }

    public static String convert(String s, int n) {
        //code here
        String[] arr = new String[n + 1];
        int len = s.length();
        boolean isUp = true;
        int index = 0;
        for (int i = -1; i < len; ) {
            if (isUp) {
                for (int j = 0; j < n; j++) {
                    i++;
                    if (i < len) {
                        arr[j] = (arr[j] != null) ? (arr[j] + s.charAt(i)) : "" + s.charAt(i);
                    }
                }
                isUp = false;
            } else {
                for (int j = n - 2; j >= 1; j--) {
                    i++;
                    if (i < len) {
                        arr[j] = (arr[j] != null) ? (arr[j] + s.charAt(i)) : "" + s.charAt(i);
                    }
                }
                isUp = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
        }

        return sb.toString();
    }
}
