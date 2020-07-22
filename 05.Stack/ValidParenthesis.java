import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        System.out.println(isProperParenthesis("{()[]}()[{()}]"));
    }

    private static boolean isProperParenthesis(String input) {
        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    char inStack = stack.pop();
                    if ((inStack == '(' && c != ')') || (inStack == '{' && c != '}') || (inStack == '[' && c != ']')) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty())
            return true;
        else
            return false;
    }
}