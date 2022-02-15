package misc;

import java.util.Stack;

public class ReverseStackLogic {
    public static void main(String[] args) {
        String input = "Testing is bad thing";
        System.out.println("Reverse string solution using Stack. \nInput : \n" + input + "\nOutput :");
        String rev = reverse(input);
        System.out.println(rev);
    }

    private static String reverse(String input) {
        char inputArray[] = input.toCharArray();
        char outputArray[] = new char[input.length()];
        Stack<Character> stack = new Stack<>();
        for (Character c : inputArray) {
            stack.push(c);
        }
        int i = 0;
        while (!stack.isEmpty()) {
            outputArray[i] = stack.pop();
            i++;
        }
        return String.valueOf(outputArray);
    }
}