package easy;

import java.util.Stack;

public class Q_014_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String op = strs[0];

        for (String s : strs) {
            if (s == null || "".equals(s)) return "";
            String currPrev = "";
            int i = 0;
            while (i < op.length() && i < s.length() && op.charAt(i) == s.charAt(i)) {
                currPrev += op.charAt(i);
                i++;
            }
            if ("".equals(currPrev)) {
                return "";
            } else if (currPrev.length() < op.length()) {
                op = currPrev;
            }
        }
        return op;
    }
}
