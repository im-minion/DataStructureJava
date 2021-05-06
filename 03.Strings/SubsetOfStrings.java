import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetOfStrings {
    public static void main(String[] args) {
        solve("AB", "");
        List<String> op = solveUnique("AAB", "");
        System.out.println(op);

        System.out.println("********************************************************************");

        // FOR INTEGER UNIQUE SUBSET ITS LITTLE INCORRECT
        int[] a = {2, 1, 2};
        ArrayList<ArrayList<Integer>> opt = AllSubsets(a, a.length);
        System.out.println(opt);
    }

    private static void solve(String input, String output) {
        if (input.length() == 0) {
            System.out.println(output);
            return;
        }

        String out1 = output;
        String out2 = output;

        out2 += input.charAt(0);
        input = input.substring(1);

        solve(input, out1);
        solve(input, out2);
    }

    private static List<String> solveUnique(String input, String output) {
        List<String> op = new ArrayList<>();
        solveUn(input, output, op);
        return op;
    }

    private static void solveUn(String input, String output, List<String> op) {
        if (input.length() == 0) {
            if (!op.contains(output))
                op.add(output);
            return;
        }

        String out1 = output;
        String out2 = output;

        out2 += input.charAt(0);
        input = input.substring(1);

        solveUn(input, out1, op);
        solveUn(input, out2, op);
    }

    public static ArrayList<ArrayList<Integer>> AllSubsets(int arr[], int n) {
        // your code here
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> op = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();

        solve(op, arr, output);

        return op;
    }

    private static void solve(ArrayList<ArrayList<Integer>> op, int[] input, ArrayList<Integer> output) {
        if (input.length == 0) {
            if (!op.contains(output))
                op.add(output);
            return;
        }

        ArrayList<Integer> output1 = new ArrayList<>(output);

        ArrayList<Integer> output2 = new ArrayList<>(output);

        output2.add(input[0]);

        int[] newIp = Arrays.copyOfRange(input, 1, input.length);

        solve(op, newIp, output1);
        solve(op, newIp, output2);
    }
}
