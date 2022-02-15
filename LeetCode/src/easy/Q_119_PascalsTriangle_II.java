import java.util.ArrayList;
import java.util.List;

public class Q_119_PascalsTriangle_II {
    public static void main(String[] args) {
    }

    public List<Integer> getRow(int rowIndex) {

        int n = rowIndex + 1;

        List<List<Integer>> op = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> l = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    l.add(1);
                } else {
                    l.add(op.get(i - 1).get(j - 1) + op.get(i - 1).get(j));
                }
            }
            op.add(l);
        }

        return op.get(rowIndex);
    }
}
