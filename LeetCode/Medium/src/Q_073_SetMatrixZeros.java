import java.util.ArrayList;

public class Q_073_SetMatrixZeros {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        // works with java 11+
//        List<Pair<Integer, Integer>> pairs = new ArrayList<>();
//
//        for(int i = 0 ; i < matrix.length ; i++) {
//            for(int j = 0 ; j < matrix[i].length ; j++) {
//                if(matrix[i][j] == 0) {
//                    pairs.add(new Pair(i,j));
//                }
//            }
//        }
//
//        for(Pair<Integer, Integer> p : pairs) {
//            int k = p.getKey();
//            int v = p.getValue();
//            for(int i = 0 ; i < matrix[0].length ; i++) {
//                matrix[k][i] = 0;
//            }
//
//            for(int i = 0 ; i < matrix.length ; i++) {
//                matrix[i][v] = 0;
//            }
//        }
    }
}
