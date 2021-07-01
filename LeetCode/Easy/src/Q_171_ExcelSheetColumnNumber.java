public class Q_171_ExcelSheetColumnNumber {
    public static void main(String[] args) {

    }

    public int titleToNumber(String columnTitle) {
        int op = 0;
        int multiplier = 1;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);
            op = op + (c - 'A' + 1) * (multiplier);
            multiplier = multiplier * 26;
        }
        return op;
    }
}
