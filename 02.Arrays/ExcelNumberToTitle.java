public class ExcelNumberToTitle {
    public static void main(String[] args) {
        String result = convertToTitle(28);
        System.out.println(result);
    }

    public static String convertToTitle(int A) {
        StringBuilder result = new StringBuilder("");
        while (A > 0) {
            int r = ((A - 1) % 26) + 65; // grab last digit
            A = (A - 1) / 26; // remove last digit
            result.append((char) r); // get the char of last digit
        }
        return result.toString().length() > 0 ? result.reverse().toString() : "";
    }
}
