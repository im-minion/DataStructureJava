public class Q_028_ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
    }

    public static int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if (haystack.equals("") && needle.equals("")) return 0;
        if (haystack.equals(needle)) return 0;

        int nL = needle.length();

        if (haystack.contains(needle)) {
            for (int i = 0; i < haystack.length(); i++) {
                if ((i + nL <= haystack.length()) && needle.equals(haystack.substring(i, i + nL))) {
                    return i;
                }
            }
        }
        return -1;

    }
}
