package misc;

public class ValidPalindrome {
    public static void main(String[] args) {
        System.out.println("Palindrome with alphanumeric characters only.");
        boolean result1 = valid("learning is essential");
        boolean result2 = valid("race car");
        boolean result3 = valid("9Ma dam9");
        System.out.println("First : " + result1);
        System.out.println("second : " + result2);
        System.out.println("Third : " + result3);

        System.out.println();
        System.out.println("Better solution.");
        boolean result4 = betterSolution("learning is essential");
        boolean result5 = betterSolution("race car");
        boolean result6 = betterSolution("9Ma dam9");
        System.out.println("First : " + result4);
        System.out.println("second : " + result5);
        System.out.println("Third : " + result6);
    }

    private static boolean valid(String input) {
        input = input.toLowerCase();
        int left = 0;
        int right = input.length() - 1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(input.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(input.charAt(right))) {
                right--;
            } else {
                if (input.charAt(left) == input.charAt(right)) {
                    right--;
                    left++;
                } else {
                    return false;
                }
            }

        }
        return true;
    }

    private static boolean betterSolution(String input) {
        input = input.toLowerCase();
        StringBuilder prunedString = new StringBuilder("");
        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                prunedString.append(c);
            }
        }
        int left = 0;
        int right = prunedString.length() - 1;
        while (left <= right) {
            if (prunedString.charAt(left) != prunedString.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}