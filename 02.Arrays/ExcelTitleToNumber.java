public class ExcelTitleToNumber {
    public static void main(String[] args) {
        int result = titleToNumber("ZZ");
        System.out.println(result);
    }

    public static int titleToNumber(String A) {
        int res = 0;
        char[] x = A.toCharArray();
        int multiplier = 1;
        for (int i = 0; i < A.length(); i++) {
            int currIndex = x[i] - 'A' + 1;
            res = res + currIndex * multiplier;
            multiplier = multiplier * 26;
        }
        return res;
    }
}
