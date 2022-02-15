package medium;

import java.util.ArrayList;
import java.util.List;

public class Q_022_GenerateParenthesis {
    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> op = new ArrayList<>();
        generate("", n, 0, 0, op);
        return op;
    }

    private static void generate(String s, int n, int open, int close, List<String> op) {
        if (open > n || close > open)
            return;

        if (open == n && close == n) {
            op.add(s);
            return;
        }

        generate(s + "(", n, open + 1, close, op);
        generate(s + ")", n, open, close + 1, op);
    }

}
