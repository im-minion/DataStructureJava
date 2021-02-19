public class StrStr {
    public static void main(String[] args) {
        System.out.println(strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));//48

        System.out.println(strStr("aaaaabbabbaaaababbbbaaabbbaababaababbaabaabaaabbabab", "bbbaababaa"));// 23

    }

    public static int strStr(final String A, final String B) {
        // a- "aabasd"
        // b- "asd"
        // Output: 3
        if (A.length() < B.length()) {
            return -1;
        }
        if (A.length() == B.length()) {
            if (A.equals(B)) {
                return 0;
            } else {
                return -1;
            }
        }
        char[] arr = A.toCharArray();
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (A.charAt(i) == B.charAt(j)) {
                if ((B.length() - 1) == j) {
                    return i - j;
                } else {
                    j++;
                }
            } else {
                i = i - j;
                j = 0;
            }
        }
        return -1;
    }
}
