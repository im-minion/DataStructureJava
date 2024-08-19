package backtracking;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

// complexity 2 raise to n
public class YT_03bPermutationWithSpaces {
    public static void main(String[] args) {
        System.out.println(permutation("abc"));
    }


    static ArrayList<String> permutation(String S) {
        // Code Here
        Set<String> op = new TreeSet<String>();

        solve(0, S.length(), op, new StringBuilder(S));

        return new ArrayList<>(op);
    }

    static void solve(int pos, int n, Set<String> op, StringBuilder currStr) {

        if(pos == n - 1) {
            op.add(currStr.toString());
            return;
        }

        solve(pos + 1, n, op, currStr);
        currStr.insert(pos + 1,  ' ');
        solve(pos + 2, n + 1, op, currStr);
        currStr.deleteCharAt(pos + 1);
    }
}
