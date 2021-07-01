public class ExcelTitleToNumber {
    public static void main(String[] args) {
        int result = titleToNumber("ZZ");
        System.out.println(result);
    }

    public static int titleToNumber(String columnTitle) {
        int op = 0;
        int multiplier = 1;
        for(int i = columnTitle.length() - 1; i >=0 ;i--) {
            char c = columnTitle .charAt(i);
            op = op + (c - 'A' + 1) * (multiplier);
            multiplier = multiplier * 26;
        }
        return op;
    }
}
