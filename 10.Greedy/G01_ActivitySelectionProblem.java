import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

//        solveSortedFinishedTimeOrder(s, f, n);

        s = new int[]{5, 1, 3, 0, 5, 8};
        f = new int[]{9, 2, 4, 6, 7, 9};
        n = s.length;
        solveUnSortedFinishedTimeOrder(s, f, n);
    }

    private static void solveUnSortedFinishedTimeOrder(int[] s, int[] f, int n) {
        class Activity implements Comparable<Activity> {
            int st;
            int fn;

            public Activity(int st, int fn) {
                this.st = st;
                this.fn = fn;
            }

            @Override
            public int compareTo(Activity a) {
                return this.fn - a.fn;
            }

            @Override
            public String toString() {
                return "Activity{" +
                        "st=" + st +
                        ", fn=" + fn +
                        '}';
            }
        }
        List<Activity> l = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            l.add(new Activity(s[i], f[i]));
        }
        Collections.sort(l);
        System.out.println(l);
        int i = 0;
        int j;
        System.out.println("Selected :" + l.get(i));
        for (j = 1; j < n; j++) {
            if (l.get(i).fn <= l.get(j).st) {
                System.out.println("Selected :" + l.get(j));
                i = j;
            }
        }
    }

    private static void solveSortedFinishedTimeOrder(int[] s, int[] f, int n) {
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
