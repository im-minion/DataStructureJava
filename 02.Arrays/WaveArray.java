import java.util.ArrayList;
import java.util.Collections;

public class WaveArray {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        ArrayList<Integer> res = wave(a);
        for (int cal : res) {
            System.out.println(cal);
        }
    }

    public static ArrayList<Integer> wave(ArrayList<Integer> A) {
        Collections.sort(A);
        ArrayList<Integer> result = new ArrayList<>();
        int halfSize = A.size() / 2;
        for (int i = 0; i < A.size() - 1; i++) {
            result.add(A.get(i + 1));
            result.add(A.get(i));
            i++;
        }
        if (A.size() % 2 != 0) {
            result.add(A.get(A.size() - 1));
        }
        return result;
    }
}
