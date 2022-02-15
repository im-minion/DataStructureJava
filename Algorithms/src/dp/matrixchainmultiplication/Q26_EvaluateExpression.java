package dp.matrixchainmultiplication;

import java.util.HashMap;

/*
Boolean Parenthesization Problem | DP-37
Difficulty Level : Expert
Last Updated : 02 Feb, 2021
Given a boolean expression with following symbols.

Symbols
'T' ---> true
'F' ---> false
And following operators filled between symbols

Operators
&   ---> boolean AND
|   ---> boolean OR
^   ---> boolean XOR
Count the number of ways we can parenthesize the expression so that the value of expression evaluates to true.
Let the input be in form of two arrays one contains the symbols (T and F) in order and other contains operators (&, | and ^}
Examples:

Input: symbol[]    = {T, F, T}
operator[]  = {^, &}
Output: 2
The given expression is "T ^ F & T", it evaluates true
in two ways "((T ^ F) & T)" and "(T ^ (F & T))"

Input: symbol[]    = {T, F, F}
operator[]  = {^, |}
Output: 2
The given expression is "T ^ F | F", it evaluates true
in two ways "( (T ^ F) | F )" and "( T ^ (F | F) )".

Input: symbol[]    = {T, T, F, T}
operator[]  = {|, &, ^}
Output: 4
The given expression is "T | T & F ^ T", it evaluates true
in 4 ways ((T|T)&(F^T)), (T|(T&(F^T))), (((T|T)&F)^T)
and (T|((T&F)^T)).
*/
public class Q26_EvaluateExpression {
    //using hashmap for memoize
    private static HashMap<String, Integer> map;

    public static void main(String[] args) {
        char[] symbols = {'T', 'F', 'T'};
        char[] operators = {'^', '&'};
        map = new HashMap<>();
        System.out.println(countParenthesis(symbols, operators));
    }

    private static int countParenthesis(char[] symbols, char[] operators) {
        char[] newArr = new char[symbols.length + operators.length];
        int s = 0;
        int o = 0;
        for (int i = 0; i < newArr.length; i = i + 2) {
            newArr[i] = symbols[s++];
        }
        for (int i = 1; i < newArr.length; i = i + 2) {
            newArr[i] = operators[o++];
        }
//        return solve(newArr, 0, newArr.length - 1, true);
        return solveByMemoize(newArr, 0, newArr.length - 1, true);
    }

    private static int solveByMemoize(char[] arr, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue) {
                return arr[i] == 'T' ? 1 : 0;
            } else {
                return arr[i] == 'F' ? 1 : 0;
            }
        }
        String key = i + "_" + j + "_" + isTrue;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int ans = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lt = solve(arr, i, k - 1, true);
            int lf = solve(arr, i, k - 1, false);
            int rt = solve(arr, k + 1, j, true);
            int rf = solve(arr, k + 1, j, false);


            switch (arr[k]) {
                case '&':
                    if (isTrue) {
                        ans += lt * rt;
                    } else {
                        ans += lt * rf + lf * rt + lf * rf;
                    }
                    break;
                case '|':
                    if (isTrue) {
                        ans += lt * rt + lt * rf + lf * rt;
                    } else {
                        ans += lf * rf;
                    }
                    break;
                case '^':
                    if (isTrue) {
                        ans += lt * rf + lf * rt;
                    } else {
                        ans += lt * rt + lf * rf;
                    }
                    break;
            }
        }
        map.put(key, ans);
        return ans;
    }

    private static int solve(char[] arr, int i, int j, boolean isTrue) {
        if (i > j) return 0;
        if (i == j) {
            if (isTrue) {
                return arr[i] == 'T' ? 1 : 0;
            } else {
                return arr[i] == 'F' ? 1 : 0;
            }
        }
        int ans = 0;
        for (int k = i + 1; k <= j - 1; k = k + 2) {
            int lt = solve(arr, i, k - 1, true);
            int lf = solve(arr, i, k - 1, false);
            int rt = solve(arr, k + 1, j, true);
            int rf = solve(arr, k + 1, j, false);

            switch (arr[k]) {
                case '&':
                    if (isTrue) {
                        ans += lt * rt;
                    } else {
                        ans += lt * rf + lf * rt + lf * rf;
                    }
                    break;
                case '|':
                    if (isTrue) {
                        ans += lt * rt + lt * rf + lf * rt;
                    } else {
                        ans += lf * rf;
                    }
                    break;
                case '^':
                    if (isTrue) {
                        ans += lt * rf + lf * rt;
                    } else {
                        ans += lt * rt + lf * rf;
                    }
                    break;
            }
        }

        return ans;
    }
}
