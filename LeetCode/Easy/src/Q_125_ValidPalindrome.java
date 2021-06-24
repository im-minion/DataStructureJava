public class Q_125_ValidPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));
    }

    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();

        while (i <= j) {
            char cI = s.charAt(i);
            char cJ = s.charAt(j);
            if ((Character.isAlphabetic(cI) || Character.isDigit(cI)) && (Character.isAlphabetic(cJ) || Character.isDigit(cJ))) {
                if (cI != cJ) {
                    return false;
                } else {
                    i++;
                    j--;
                }
            } else {
                if (!(Character.isAlphabetic(cI) || Character.isDigit(cI))) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return true;
    }
}
