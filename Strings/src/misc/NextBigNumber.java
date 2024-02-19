package misc;

import java.util.Arrays;

public class NextBigNumber {
    /*Input:  n = "218765"
Output: "251678"

Input:  n = "1234"
Output: "1243"

Input: n = "4321"
Output: "Not Possible"

Input: n = "534976"
Output: "536479"*/

    public static void main(String[] args) {
        String s = "218765";
        String op = solve(s); // 251678
        System.out.println(op);
    }

    static String solve(String ip) {
        String op = "";
        char[] arr = ip.toCharArray();
        int n = arr.length;
        int i;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }

        if (i == 0) {
            return "Not possible";
        }
        int indexMin = i;
        int p = arr[i - 1];

        for (int j = i + 1; j < n; j++) {
            if (arr[j] > p && arr[j] < arr[indexMin]) {
                indexMin = j;
            }
        }


        // swap
        char t = arr[indexMin];
        arr[indexMin] = arr[i - 1];
        arr[i - 1] = t;

        Arrays.sort(arr, i - 1, indexMin);

        for (i = 0; i < n; i++)
            System.out.print(arr[i]);


        return op;
    }
}
