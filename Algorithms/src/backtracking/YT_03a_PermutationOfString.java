package backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// complexity n!
public class YT_03a_PermutationOfString {
    public static void main(String[] args) {
        System.out.println(find_permutation("abc"));
    }

    public static List<String> find_permutation(String S) {
        // Code here
        Set<String> op = new TreeSet<>();

        solve(0, S.length(), op, S.toCharArray());

        // Collections.sort(op);
        return new ArrayList<>(op);
    }

    private static void solve(int pos, int n, Set<String> op, char[] currStr) {
        if (pos == n - 1) {
            op.add(new String(currStr));
            return;
        }
        int i;
        for (i = pos; i < n; i++) {
            swapStr(currStr, pos, i);
            solve(pos + 1, n, op, currStr);
            swapStr(currStr, pos, i);
        }
    }

    private static void swapStr(char[] currStr, int pos, int i) {
        char temp = currStr[pos];
        currStr[pos] = currStr[i];
        currStr[i] = temp;
    }
}
