package misc;

public class ToLowerCase {
    public static void main(String[] args) {
        String input = "Testing IS Bad";
        System.out.println("Enter the string to convert it to lowercase:");

        String lowercase = convertToLowerCase(input);
        System.out.println("String in lower case " + lowercase);
    }

    private static String convertToLowerCase(String input) {
        StringBuilder sb = new StringBuilder("");
        for (Character c : input.toCharArray()) {
            if (Character.isUpperCase(c)) {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }
        return String.valueOf(sb);
    }
}