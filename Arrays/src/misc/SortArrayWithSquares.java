package misc;

import java.util.ArrayList;
import java.util.Collections;

public class SortArrayWithSquares {
    public static void main(String[] args) {
        ArrayList<Integer> x = new ArrayList<>();
        x.add(-2);
        x.add(5);
        x.add(3);
        ArrayList<Integer> result = solve(x);
        for (Integer r : result) {
            System.out.println(r);
        }
    }

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        ArrayList<Integer> X = new ArrayList<>();
        for (Integer a : A) {
            X.add(Math.abs(a));
        }
        Collections.sort(X);
        int count = 0;
        for (Integer x : X) {
            X.set(count++, x * x);
        }

        return X;
    }
}
