import java.util.ArrayList;

/*
 * Rearrange a given array so that Arr[i] becomes Arr[Arr[i]] with O(1) extra space.
 * Input : [1, 0]
 * Return : [0, 1]
 *
 * Lets say N = size of the array. Then, following holds true :
 * All elements in the array are in the range [0, N-1]
 * N * N does not overflow for a signed integer
 * */
public class Rearrange {
    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(0);
        A.add(4);
        A.add(1);
        A.add(2);
        arrange(A);
        System.out.println(A);
    }

    public static void arrange(ArrayList<Integer> A) {
        // using Encoding technique
        int size = A.size();
        A.replaceAll(e -> (A.get(e) % size) * size + e);
        A.replaceAll(e -> e / size);
    }
}
