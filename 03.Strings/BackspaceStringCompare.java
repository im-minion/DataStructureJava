public class BackspaceStringCompare {
    /**
     * 
     * Given two strings S and T, return if they are equal when both are typed into
     * empty text editors. # means a backspace character.
     * 
     * Note that after backspacing an empty text, the text will continue empty.
     * 
     * Example 1: Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and
     * T become "ac".
     * 
     * Example 2: Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and
     * T become "".
     * 
     * Example 3: Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and
     * T become "c".
     * 
     * Example 4: Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c"
     * while T becomes "b".
     *
     */
    public static void main(String[] args) {
        System.out.println("String comparison after removal characters of backspace solution.");
        System.out.println("# represents backspace in text editor and the character before # is removed.");
        boolean first = compareString("hel#lo", "helo");
        System.out.println("String are equal ? " + first);
        System.out.println("# represents backspace in text editor and the character before # is removed.");
        boolean second = compareString("buff##alo", "bu#ffa#lo");
        System.out.println("String are equal ? " + second);
    }

    private static boolean compareString(String S, String T) {
        int sPointer = S.length() - 1;
        int tPointer = T.length() - 1;

        int sSKips = 0, tSkips = 0;
        while (sPointer >= 0 || tPointer >= 0) {
            while (sPointer >= 0) {
                if (S.charAt(sPointer) == '#') {
                    sSKips++;
                    sPointer--;
                } else if (sSKips > 0) {
                    sPointer--;
                    sSKips--;
                } else {
                    break;
                }
            }
            while (tPointer >= 0) {
                if (T.charAt(tPointer) == '#') {
                    tSkips++;
                    tPointer--;
                } else if (tSkips > 0) {
                    tPointer--;
                    tSkips--;
                } else {
                    break;
                }
            }
            if (sPointer >= 0 && tPointer >= 0 && S.charAt(sPointer) != T.charAt(tPointer)) {
                return false;
            }
            if (sPointer >= 0 != tPointer >= 0) {
                return false;
            }
            sPointer--;
            tPointer--;
        }

        return true;
    }
}