
/**
 * 
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Note:
 * 
 * Division between two integers should truncate toward zero. The given RPN
 * expression is always valid. That means the expression would always evaluate
 * to a result and there won't be any divide by zero operation. 
 * 
 * Example 1:
 * 
 * Input: ["2", "1", "+", "3", "*"] Output: 9 
 * 
 * Explanation: ((2 + 1) * 3) = 9
 * 
 * 
 * Example 2:
 * 
 * Input: ["4", "13", "5", "/", "+"] Output: 6 
 * 
 * Explanation: (4 + (13 / 5)) = 6
 * 
 * 
 * Example 3:
 * 
 * Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
 * Output: 22 
 * 
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = ((10 * (6 /
 * (12 * -11))) + 17) + 5 = ((10 * (6 / -132)) + 17) + 5 = ((10 * 0) + 17) + 5 =
 * (0 + 17) + 5 = 17 + 5 = 22
 * 
 */

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] ip = { "2", "1", "+", "3", "*" };
        int result = evalRPN(ip);
        System.out.println(result);

        String[] ip2 = { "4", "13", "5", "/", "+" };
        int result2 = evalRPN(ip2);
        System.out.println(result2);

        String[] ip3 = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        int result3 = evalRPN(ip3);
        System.out.println(result3);

    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                s.add(s.pop() + s.pop());
            } else if (token.equals("-")) {
                int a = s.pop();
                int b = s.pop();
                s.add(b - a);
            } else if (token.equals("*")) {
                int a = s.pop();
                int b = s.pop();
                s.add(a * b);
            } else if (token.equals("/")) {
                int a = s.pop();
                int b = s.pop();
                s.add(b / a);
            } else {
                s.add(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
}