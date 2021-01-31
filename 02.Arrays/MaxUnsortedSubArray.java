import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxUnsortedSubArray {

    public static void main(String[] args) {
        ArrayList<Integer> r = new ArrayList<Integer>();
        r.add(1);
        r.add(3);
        r.add(2);
        r.add(4);
        r.add(5);
        ArrayList<Integer> result = subUnsort(r);
        System.out.println(result);
    }

    public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {
        ArrayList<Integer> result = new ArrayList<>();
        List<Integer> sortedA = new ArrayList<>(A);
        Collections.sort(sortedA);
        int count = 0;
        int minIndex = 0;
        int maxIndex = 0;
        for (int i = 0; i < A.size(); i++) {
            if (!A.get(i).equals(sortedA.get(i))) {
                count++;
                if (count == 1) {
                    minIndex = i;
                }
                maxIndex = i;
            }
        }
        if (minIndex == 0 && maxIndex == 0) {
            result.add(-1);
            return result;
        }
        result.add(minIndex);
        result.add(maxIndex);
        return result;
    }
}
