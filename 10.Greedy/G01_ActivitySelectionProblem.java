/*
 * Greedy:
 * Builds up a solution piece by piece
 * Used for optimization problem
 * *****
 * An optimization problem can be solved using Greedy if the problem has the following property:
 * "At every step, we can make a choice that looks best at the moment,
 * and we get the optimal solution of the complete problem."
 * */
public class G01_ActivitySelectionProblem {
    public static void main(String[] args) {
        // sorted finish time
        int[] s = {1, 3, 0, 5, 8, 5};
        int[] f = {2, 4, 6, 7, 9, 9};
        int n = s.length;

        solveSortedFinishedTimeORder(s, f, n);
    }

    private static void solveSortedFinishedTimeORder(int[] s, int[] f, int n) {
        int i = 0;
        int j;
        System.out.println("Selected :" + i);
        for (j = 1; j < n; j++) {
            if (f[i] <= s[j]) {
                System.out.println("Selected :" + j);
                i = j;
            }
        }
    }
}
