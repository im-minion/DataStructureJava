public class ExcelNumberToTitle {
    public static void main(String[] args) {
        String result = convertToTitle(28);
        System.out.println(result);
    }

    public static String convertToTitle(int A) {
        StringBuilder result = new StringBuilder("");
        while (A > 0) {
            int r = ((A - 1) % 26) + 65;
            A = (A - 1) / 26;
            result.append((char) r);
        }
        return result.toString().length() > 0 ? result.reverse().toString() : "";
    }
}
