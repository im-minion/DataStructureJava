package misc;

import java.util.Stack;

/**
 * 
 * Basic Calculator
 * 
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string may contain open ( and closing parentheses ), the plus
 * + or minus sign -, non-negative integers and empty spaces .
 * 
 * Example 1:
 * 
 * Input: "1 + 1" Output: 2
 * 
 * Example 2:
 * 
 * Input: " 2-1 + 2 " Output: 3
 * 
 * Example 3:
 * 
 * Input: "(1+(4+5+2)-3)+(6+8)" Output: 23
 * 
 * Note: You may assume that the given expression is always valid. Do not use
 * the eval built-in library function.
 */

public class BasicCalculator {
    public static void main(String[] args) {
        int result = calculate("1 + 1");
        System.out.println(result + "\n\n");

        System.out.println(calculate(" 2-1 + 2 ") + "\n\n");
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)") + "\n\n");
        System.out.println(calculate("     4 + 5") + "\n\n");
        System.out.println(calculate("2147483647") + "\n\n");
        System.out.println(calculate("2147483647 - 1") + "\n\n");
    }

    public static int calculate(String s) {
        int result = 0;
        int sign = 1; // 1 => + and -1 => -
        int number = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                number = 10 * number + (int) (c - '0');
                // we need to do 10 * number to handle more than 1 digit number eg ."2147483647"
                // "2147483647"
            } else {
                switch (c) {
                    case '+':
                        result = result + sign * number;
                        number = 0;
                        sign = 1;
                        break;
                    case '-':
                        result = result + sign * number;
                        number = 0;
                        sign = -1;
                        break;
                    case '(':
                        // store result to stack
                        stack.push(result);
                        // store sign of result to stack
                        stack.push(sign);

                        // reset all data
                        result = 0;
                        number = 0;
                        sign = 1;
                        break;
                    case ')':
                        result = result + sign * number;

                        // get sign from stack
                        result = result * stack.pop();
                        // add current result to existing result
                        result = result + stack.pop();

                        // reset all data
                        number = 0;
                        sign = 1;

                        break;
                }
            }
        }
        if (number != 0) {
            result = result + sign * number;
        }

        return result;
    }
}