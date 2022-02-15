package misc;

import java.util.Stack;

public class ReverseOnlyLetterStackLogic {
    public static void main(String[] args) {
        String input = "Testing is bad-thing";
        System.out.println("Reverse string => Only letters, preserve others (space, -, etc) solution using Stack. \nInput : \n" + input + "\nOutput :");
        String rev = reverse(input);
        System.out.println(rev);
    }

    private static String reverse(String input) {
        char inputArray[] = input.toCharArray();
        char outputArray[] = new char[input.length()];
        Stack<Character> stack = new Stack<>();
        for (Character c : inputArray) {
            if (Character.isLetter(c))
                stack.push(c);
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                outputArray[i] = input.charAt(i);
            } else if (!stack.isEmpty()) {
                outputArray[i] = stack.pop();
            }
        }
        return String.valueOf(outputArray);
    }
}